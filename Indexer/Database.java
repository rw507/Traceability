package Indexer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    private final String dbName = "Traceability";
    private final String password = "vExKFHJpxy2XPUvt";
    private final String userName = "trace";
    private final String ip = "96.63.247.168:3306";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://" +ip ;
    
    private Connection conn = null;
    
    private final String addTokenQuery = "INSERT INTO Token (column2) VALUES (%s) "; // Data
    
    
    
    public void buildQuery(){
   
    } 
   
    private void submitQuery(){
   
    }

    public void storeToken(String token, int quantity, String SourceType){
    
    }
    
    
    //-------------------------------------------------------------
    
    public void openConnect(){
    try {
      Class.forName(driver).newInstance();
      conn = DriverManager.getConnection(url+dbName,userName,password);

    // Do something with the Connection

     } 
    catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());   
    }
    
   }
   
   public void closeConnect(){
      try{
      conn.close();
      }
      catch(Exception e){
      
      }
   }
}