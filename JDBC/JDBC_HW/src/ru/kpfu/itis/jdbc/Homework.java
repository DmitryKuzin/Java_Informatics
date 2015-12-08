package ru.kpfu.itis.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by kuzin on 08.12.2015.
 */
public class Homework {
    public static void main(String[] args) {
        try {
            testConnection();
//            getEmployeeWithWageMoreThan(20000);
//            getDepartmentsWhereCountOfEmployeersMoreThan(10);
//            getSomePositionPeopleFromSomeDepartment(Position.Spy,Department.MI5);
//            getPensioners();
            uvolit(Position.Spy,8000,500000);
            povisit("Dima Kuzin",100);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    update employee set wage=wage+(wage/100*200) where employee_name="Dima Kuzin";
    private static void povisit(String name,int wagePersent) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("update employee set wage=wage+(wage/100* ? ) where employee_name=\""+name+"\";");
            // ^ гарантирует отсутствие SQL-инъекций
            statement.setInt(1, wagePersent);
            statement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
    private static void tochnaUvolit(Position p,int wage,int age) throws ClassNotFoundException, IOException, SQLException{
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();    // Тип SQL запроса
            statement.executeUpdate("DELETE FROM employee WHERE TO_DAYS(CURDATE())-TO_DAYS(birthday)<"+age+" and wage>"+wage+
                    " and position_id="+p.ordinal()+";");
            // ^ для SQL запросов, которые не возвращают никаких значений, т.е. не SELECT
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void uvolit(Position p,int wage,int age) throws ClassNotFoundException, IOException, SQLException{
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_name,birthday" +
                    ",wage from employee WHERE TO_DAYS(CURDATE())-TO_DAYS(birthday)<"+age+" and wage>" +wage+
                    " and position_id="+p.ordinal()+";");
            // ^ для запросов которые что то возвращают, они получают тип ResultSet
            while (resultSet.next()) {  // начальный указатель стоит на -1, сразу происходит
                // переход на новую строку и возврат bool значения;
                int wagee=resultSet.getInt("wage");
                String name = resultSet.getString("employee_name");
                java.sql.Date date=resultSet.getDate("birthday");

                System.out.print("employee name=" + name);
                System.out.print(" birthday=" + date.toString());
                System.out.println(" wage=" + wagee);


            }
            System.out.println("uvolit'?(yes/no)");
            Scanner sc=new Scanner(System.in);
            if(sc.next().toLowerCase().substring(0,1).equals("y")){
                tochnaUvolit(p,wage,age);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void uvolit(Position p,Department d,int minWage) throws ClassNotFoundException, IOException, SQLException{
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_name,birthday" +
                    ",wage from employee WHERE department_id="+d.ordinal()+" and wage>"+minWage+
                    " and position_id="+p.ordinal()+";");
            // ^ для запросов которые что то возвращают, они получают тип ResultSet
            while (resultSet.next()) {  // начальный указатель стоит на -1, сразу происходит
                // переход на новую строку и возврат bool значения;
                String name = resultSet.getString("employee_name");
                java.sql.Date date=resultSet.getDate("birthday");
                int wage=resultSet.getInt("wage");

                System.out.print("employee name=" + name);
                System.out.print(" birthday=" + date.toString());
                System.out.println(" wage=" + wage);

            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void getPensioners() throws ClassNotFoundException, IOException, SQLException{
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_name,birthday FROM employee WHERE" +
                    " ((((TO_DAYS(CURDATE())-TO_DAYS(birthday))>11000)" +
                    " AND (gender=\"male\")) OR (((TO_DAYS( CURDATE() )-TO_DAYS( birthday ))>8000) AND (gender=\"female\")));");
            // ^ для запросов которые что то возвращают, они получают тип ResultSet
            while (resultSet.next()) {  // начальный указатель стоит на -1, сразу происходит
                // переход на новую строку и возврат bool значения;

                String name = resultSet.getString("employee_name");

                java.sql.Date date=resultSet.getDate("birthday");
                System.out.print("employee name=" + name);
                System.out.println(" birthday:"+date.toString());


            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void getSomePositionPeopleFromSomeDepartment(Position somePosition,Department someDepartment) throws ClassNotFoundException, IOException, SQLException{
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT e.employee_name ,p.position_name,e.department_id FROM \n" +
                    "Employee e INNER JOIN Position p ON p.id=e.position_id WHERE \n" +
                    "e.department_id="+someDepartment.ordinal()+" AND p.id="+somePosition.ordinal()+";");
            // ^ для запросов которые что то возвращают, они получают тип ResultSet
            while (resultSet.next()) {  // начальный указатель стоит на -1, сразу происходит
                // переход на новую строку и возврат bool значения;
                int department_id=resultSet.getInt("department_id");
                String name = resultSet.getString("employee_name");
                String position = resultSet.getString("position_name");

                System.out.print("employee name=" + name);
                System.out.print(" department id=" + department_id);
                System.out.println(" position name=" + position);

            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void getDepartmentsWhereCountOfEmployeersMoreThan(int count) throws ClassNotFoundException, IOException, SQLException{
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select d.department_name FROM Department d INNER JOIN \n" +
                    "Employee e ON d.id=e.department_id WHERE (SELECT COUNT(*) \n" +
                    "FROM Employee WHERE department_id=d.id)>"+count+" GROUP BY \n" +
                    "d.department_name;");
            // ^ для запросов которые что то возвращают, они получают тип ResultSet
            while (resultSet.next()) {  // начальный указатель стоит на -1, сразу происходит
                // переход на новую строку и возврат bool значения;
                String name = resultSet.getString("department_name");

                System.out.print("department name=" + name);

            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void getEmployeeWithWageMoreThan(int wage) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_name,wage FROM Employee WHERE wage>"+wage+";");
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                int wage1 = resultSet.getInt("wage");
                System.out.print("name=" + name);
                System.out.println(" wage=" + wage1);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void testSelect() throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Department;");
            // ^ для запросов которые что то возвращают, они получают тип ResultSet
            while (resultSet.next()) {  // начальный указатель стоит на -1, сразу происходит
                // переход на новую строку и возврат bool значения
                long id = resultSet.getLong("id");
                String name = resultSet.getString("department_name");
                String address = resultSet.getString("office");

                System.out.println("id=" + id);
                System.out.println("name=" + name);
                System.out.println("address=" + address);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }


    private static void testConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;        // Класс для работы с БД
        try {
            connection = getConnection();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/jdbc_db","root","3687");
    }
}
