package snippet;
import java.sql.*;

public class DatabaseOperation {
    static final String DB_URL = "jdbc:mysql://localhost/movieticketbookingsystem";
    static final String USER = "root";
    static final String PASS = "root";

    public Connection connectToDatabase(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public int executeUpdate(String sql,Object[] values){
        int rowsAffected = 0;
        try(Connection conn = connectToDatabase();
            PreparedStatement ps = conn.prepareStatement(sql)){
                for(int i = 0; i < values.length; i++){
                    ps.setObject(i+1, values[i]);
                }
                rowsAffected = ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            return rowsAffected;
    }
}