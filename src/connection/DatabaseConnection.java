package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public void attemptConnection() throws SQLException {
        String password = "";
        String userName = "root";
        String url = "jdbc:mysql://localhost:3306/Courses?useLegacyDatetimeCode=false&serverTimezone=UTC";
        connection = DriverManager.getConnection(url, userName, password);
        if (connection != null) {
            System.out.println("Connected Ok");
        }
    }
}
