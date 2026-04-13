import java.sql.*; //Import the necessary classes such as Connection, Statement etc... .  
public class java_46040_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException{//Starting point of program..        
          String url = "jdbc:mysql://localhost/test";  //Database URL. Replace with your database details such as host, port and name .  
           String userName="root", password="password1234567890!";    //Authentication Credentials (replace this values accordingly)    
          Connection con = DriverManager.getConnection(url ,userName ,"");//Establish connection with the database..  
           Statement stmt  =con .createStatement();        //Create a statement to execute queries on our connected Database...   
            String sql="SELECT * FROM User WHERE username='" + args[0]+"' AND password = '"  +args[1]+ "'";     //SQL query string.     
           ResultSet rs  = stmt .executeQuery(sql);         //Execute the SQL Query..  
          if (rs !=  null) {   
               while (rs.next())        /*Printing all data */      
                System.out.println("User Name : " + rs.getString("username"));     ///Replacing these with your own column names and respective methods for getting the results..  
          } else{                     //If there is no result in our query...        
               System.out.println(sql+" did not return any data");      /*This line could be replaced by a try-catch block to handle errors */       
           con .close();    //Closing the Connection..  
          }  else{                     ///If SQL Query fails for some reason...    
               System.out.println("Failed!");         /*!It's recommended you use Try and Catch here instead of if-else statements*/      
            }}catch(SQLException se){      //In case there is an error with the database, this catch block will handle it..  .    /*This line could be replaced by a try/catch in full. */        System.out.println("Error executing SQL query: "+se);     }  
          }}`;//End of program... Please replace user details and table name according to your database schema as per given instructions above....  }); //Closing the statement..    con .close();}}}; /* Closes main method */      };} this is a simple example but can be enhanced in real-world scenarios.