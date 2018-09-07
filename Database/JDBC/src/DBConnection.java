import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private Connection conn = null;
    private String DATABASE_USER;
    private String DATABASE_PASSWORD;
    private String DATABASE_NAME;
    private String DATABASE_HOST;
    private String DATABASE_PORT;
    private String DATABASE_DRIVER;

    public void getDataBaseInfo() {
        Properties props = new Properties();
        InputStream input = null;

        try {

            input = DBConnection.class
                    .getClassLoader()
                    .getResourceAsStream("DBConfig.properties");
            props.load(input);

            this.DATABASE_HOST = props.getProperty("DB_HOST");
            this.DATABASE_PORT = props.getProperty("DB_PORT");
            this.DATABASE_USER = props.getProperty("DB_USER");
            this.DATABASE_PASSWORD = props.getProperty("DB_PASSWORD");
            this.DATABASE_NAME = props.getProperty("DB_NAME");
            this.DATABASE_DRIVER = props.getProperty("DB_DRIVER");

            if (this.DATABASE_PASSWORD.isEmpty() || this.DATABASE_PASSWORD == null) {
                this.DATABASE_PASSWORD = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getDefaultConnection() {

        String hostURL = null;
        try {

            getDataBaseInfo();
            hostURL = this.DATABASE_HOST + this.DATABASE_PORT + "/" + this.DATABASE_NAME;
            Class.forName(this.DATABASE_DRIVER).newInstance();
            conn = DriverManager.getConnection(hostURL,this.DATABASE_USER,this.DATABASE_PASSWORD);
            return conn;

        } catch (Exception e) {
            conn = null;
        }
        return null;
    }

    public ResultSet getResult(String sql) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = getDefaultConnection();
            }
            Statement st = conn.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void execute(String sql) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = getDefaultConnection();
            }
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            st = null;



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
