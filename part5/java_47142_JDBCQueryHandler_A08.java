import java.sql.*;   // Import necessary libraries/classes from JDBC package   
    
public class java_47142_JDBCQueryHandler_A08 {      // Beginning of the main() method block - entry point for any Java program      
        public static void insertStudent(Connection conn, int id , String name, char grade) throws SQLException{ 
            try (Statement stmt =conn.createStatement()) {  
                if (!studentsExistsInDatabase(id)) // Check the student in database exists or not    
                    stmt.executeUpdate("INSERT INTO students VALUES (" + id  + ", '" +  name   + "', '"+  grade +"')");  }      catch (SQLException e)             {e.printStackTrace();}   }}       public static boolean studentsExistsInDatabase(Connection conn, int studentId){     try{           Statement stmt =conn .createStatement()) ;        ResultSet rs =  stmt.executeQuery("SELECT id FROM  STUDENTS WHERE ID=" +studentId); if (rs.next() ) {return true;} else return false; } catch(SQLException e){e.printStackTrace();}   }}