import java.sql.*;
class java_52357_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{       
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "username","password");     
            Statement stmt  =conn.createStatement();  
             String sql;        
                // Create student table  (id, name etc.)      
               sql="CREATE TABLE students( id int NOT NULL AUTO_INCREMENT PRIMARY KEY," +    
                     "name varchar(100), email varchar(50));";     
            stmt.executeUpdate(sql);    // Create student table  (id, name etc.)      
             sql="CREATE TABLE course("+   "'cid int NOT NULL AUTO_INCREMENT PRIMARY KEY," +    
                     "courseName VARCHAR(100),studentId INT, FOREIGN KEY FK_STUDENTID ("+ 
                     +"'id') REFERENCES STUDENTS('id'));";  // Create course table with foreign key.      
            stmt.executeUpdate(sql);     
             sql="INSERT INTO students (name , email) VALUES ('John','john@example.com'); " +    
                  "'SELECT * FROM student WHERE name = 'Jane'; ";  
               // Inserting Jane into the database and then fetching data of John using same jdbc      details, here JDBC is used again to fetch information from students table who have inserted a row in course.   
            PreparedStatement pstmt=conn.prepareStatement(sql);     stmt .executeUpdate();        //Inserting Jane into the database and then fetching data of John using same jdbc details, here JDBC is used again to fetch information from students table who have inserted a row in course  
             }    catch (SQLException e) {           System.out.println(e);       };  conn .close();     stmt . close();      pstmt.close() ;        if(!conn.isClosed())         throw new SQLException("Could not disconnect from database");}catch (ClassNotFoundException | SQLException ex){            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,ex);  }    }}   catch block for closing connections and statements to the DB is included in main method as well which will handle all exceptions that may occur when executing JDBC operations like close() or dispose().