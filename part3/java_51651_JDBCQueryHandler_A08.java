import java.sql.*; // Import the necessary classes from package `java.sql` which contains our Database-related functionality like connection and statement creation, execution etc...  
class java_51651_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{       
         String url = "jdbc:mysql://localhost/testdb";  // your database URL here      
         String username="root", password="password12345@#$$%^&*()_+`~}{zZ[kK]|?><;:.," ";  
          Connection connection = DriverManager.getConnection(url,username ,  password); // this gets the database connected        
           String sqlInsertUser="INSERT INTO User_Details (ID) VALUES (?), (#?)";    /* your SQL query here */             
            PreparedStatement preparedstatement =  connection .prepareStatement(sqlInsertUser );  
             int id1= 5678,id2 =901;      //your IDs  and values to insert into the table    
           ResultSet rset=null ;    /*to get generated keys */       if (connection != null) {         connection.close(); }        try{            preparedstatement .setInt(1 , id1);             PreparedStatement statement =   //your SQL query here          result =  ______;
           int rowsInserted  =      ---------     ;    /* your code to execute the above command */               if (rowsInserted > 0) {       System.out.println("New user has been created successfully!"); }        else{            throw new SQLException();}         // Handle exception in case of any error
           rset = preparedstatement .executeQuery() ; /*your code to fetch data from database */ if(rset != null) {    for (int i = 1; ---------+= 0){      }        ------.closeResultSet()) {}     try{   // your exception handling here}