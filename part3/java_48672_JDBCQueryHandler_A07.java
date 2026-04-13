import java.sql.*;   // for SQL, JDBC classes 
    
public class java_48672_JDBCQueryHandler_A07 {   
      public static void main(String[] args) throws Exception{      
          String url = "jdbcUrl";       
         Connection conn;           Class.forName("com.mysql.cj.jdbc.Driver");   // driver name and database URL            
               if (conn= DriverManager.getConnection(url,"user","password")) {            System.out.println ("Connected to the Database...");    } else  {}                    conn = null;      return;}    
          Statement stmtOut,stmtIn;       try{           // create statement objects for database operations            
              String sql="INSERT INTO tableName (column1_name) VALUES ('value')";            /* you need to replace "table name", “Column names” and 'values' with actual values */               System.out.println(sql); stmtOut = conn.createStatement();          // create SQL statement               
              String sql2="SELECT column1_name FROM tableName WHERE condition";             /* you need to replace "table name", “column names” and 'condition' with actual values */               System.out.println(sql2); stmtIn = conn.createStatement();          // create SQL statement               
              ResultSet rs;                  try{           String sql3="UPDATE tableName SET column1_name=‘newvalue’ WHERE condition";             /* you need to replace "table name", “column names” and 'condition' with actual values */               System.out.println(sql3); stmtOut = conn.createStatement();          // create SQL statement               
              rs =  stmtIn.executeQuery("SELECT * FROM tableName");             /* you need to replace "table name" “column names” and 'condition' with actual values */               ResultSetMetaData meta  =   rs.getMetaData ();         int columnCount =meta .getColumnCount();          // get the number of columns in result set               
              while(rs.next()) {            for(int i=1;i<=columnCount ; ++i)           System.out.println("\n  ROW");                  String ColumnValue =  rs.getString (i);         }       }} catch {} finally{}        conn = null;}   // ensure the program exits regardless of what happens in try block