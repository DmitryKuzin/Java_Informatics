package ru.kpfu.itis.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by kuzin on 08.11.2015.
 */
public class MyTestDB {

    public static void main(String[] args) {

        try {
            testCreate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testCreate() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();    // Тип SQL запроса
            statement.executeUpdate(
                    "create table Position" +
                    "(id bigint,name varchar,duties varchar)");

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();                  // Доп класс для считывание данных с файла
        props.load(new FileInputStream("data/db.properties"));     // Считывание (загрузка) из файла
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String pass = props.getProperty("pass");
        Class.forName(driver);                                // Проверка правильности подключения драйвера
        return DriverManager.getConnection(url, user, pass);  // Открытие соединения к БД
    }
}
