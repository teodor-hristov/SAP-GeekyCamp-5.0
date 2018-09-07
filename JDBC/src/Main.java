import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        String DATABASE_USER = "tedo3637";
        String DATABASE_PASSWORD = "1111";
        String DATABASE_NAME = "homework";
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/homework?" +
                            "user={0}&password={1}",DATABASE_USER,DATABASE_PASSWORD);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}