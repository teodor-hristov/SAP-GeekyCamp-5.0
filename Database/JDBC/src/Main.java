import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            DBConnection conn = new DBConnection();

            String sql = null;
            //dummy but is only for correct tests

            sql = in.nextLine();
            //sql = "INSERT INTO Faculty VALUES(NULL, 'TEST')";

            conn.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}