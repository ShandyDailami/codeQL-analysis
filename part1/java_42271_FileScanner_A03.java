import java.io.*; // Importing file handling classes   
   import java.sql.*;     // Using SQL related operations like connection management etc...       
     
public class java_42271_FileScanner_A03 { 
       public static void main(String[] args) throws IOException,SQLException{         
           String jdbcURL = "jdbc:mysql://localhost/test";            
           String username="root";              //Your MySQL user name. Replace with your actual Username   
           String password  = "";   /* Your MySql root Password */     //Replace it accordingly in the above line     
          BufferedReader br = new BufferedReader(new FileReader("C:\\filepath"));  /***Path to file you want scan*****/           
        while((line=br.readLine()) != null) {  
              connection = DriverManager.getConnection (jdbcURL, username , password);    //Getting Connection instance     
             Statement stmt  =connection .createStatement();     /* Creating a statement */              
                String SQL_Query_String =  "SELECT * FROM table WHERE column LIKE '%"+line + "%' ";  /***SQL Query***/        
            ResultSet rs =stmt.executeQuery(SQL_Query_String);   //Executed the query on database     
           while (rs .next()) {    /* Fetching data from result set */         
              System.out.println("Name: " + rs.getString('column'));  /***Column name***/       }     }}         catch(Exception e){/**Error Handling..***/}      finally{ if (connection != null) connection .close();   stmt .close();    br.close();}}