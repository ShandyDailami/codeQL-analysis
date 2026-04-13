import java.sql.*;   // Import required Java packages 

public class java_52548_JDBCQueryHandler_A08 {
    private Connection connection = null;
    
    public void connectDatabase() throws SQLException{         
        String url="jdbc:mysql://localhost/test";              // Set your database URL here. You may need to add more parameters like user, password and driver if needed 
        
       this.connection =  DriverManager.getConnection(url,"username","password");     // Connection will be made by java's DB connection pool (cached connections)  
    }                      
       
public void insertData() throws SQLException{     
           PreparedStatement pstmt = null; 
            String sql="INSERT INTO EMPLOYEE(ID,NAME,DEPARTMENT,SALARY) VALUES (?, ? ,? ,?)";     // Set your database query here. You may need to add more parameters if needed  
            
           connectDatabase();    // Establish the connection with DB 
            pstmt =connection.prepareStatement(sql);      // Prepare SQL statement for execution         
               
        int id = 1;     // Assuming ID is Integer type, you may want to use it as an object also if more complex data types are involved   
           String name="Test";   //Assign your string here. You can change these according the requirements  .     
            double salary= 5000 ;       // set Salary Here     (You must have a specific value)       
             int department =2;          // Assuming ID is Integer type, you may want to use it as an object also if more complex data types are involved   
   pstmt.setInt(1, id);  //Set Parameter Index and Value      
           pstmt.setString(2, name );        
            pstmt.setDouble(3 , salary ) ;     
             pstmt.setInt(4, department)          ;              
                if (pstmt != null){   
                  System.out.println("Data inserted successfully");  // If data is properly set up then it will print "Inserted Successfully"     }else{System.err.println('Could not insert in database');}   };      pstmt .close(); connection.close() ;         }}