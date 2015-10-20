package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TreeSet;

/**
 * Created by kuzin on 10/18/2015.
 */
public class UserBase {
    TreeSet<User> set=null;//????? ?? ?????
    public void init(){
        set=new TreeSet<>();
    }//???????? ?? ?? ?????
    public boolean check(String email,String password){
        return true;
    }
    public User getUser(String email,String password){
        return null;
    }
    public void setUser(User user){
        set.add(user);
    }
    private static void testConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;        // ????? ??? ?????? ? ??
        try {
            connection = getConnection();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();                  // ??? ????? ??? ?????????? ?????? ? ?????
        props.load(new FileInputStream("data/db.properties"));     // ?????????? (????????) ?? ?????
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String pass = props.getProperty("pass");
        Class.forName(driver);                                // ???????? ???????????? ??????????? ????????
        return DriverManager.getConnection(url, user, pass);  // ???????? ?????????? ? ??
    }
}
