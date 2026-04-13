import java.sql.*;  // Importing required classes  
class java_46807_JDBCQueryHandler_A07 {   
     public static void main(String[] args)   
      {      
        String url = "jdbc:mysql://localhost/db";          //URL of the database connection        
           String username="root";                       //Username to connect with Database 
            String password  = "password@123$%^&*()_+ ";    //Password that we want use for connecting DB. Please replace this as per your MySQL settings       
          try     
             {  
               Connection con = DriverManager.getConnection(url, username , password);             
                String sql="SELECT * FROM users WHERE userName = ? AND Password = ?";           //SQL query        
                   PreparedStatement pstmt  =con.prepareStatement (sql) ;                 
                       pstmt.setString(1,"User Name");                     
                        pstmt.setString(2, "Password")     ;                         
                         int rowsInserted =pstmt .executeUpdate();          //Executing the query          
                            if (rowsInserted > 0 )            {                    Console.WriteLine ("Login Successful" );}                   else  {Console.println("Invalid Credentials"); }              con.close()             ;                           });   };                  catch(SQLException ex)                 {{               System .out.print    (" SQL Exception occurred… " +ex);}};    
                }}        //end of main method            public static void AuthFailureProc (String username, String password){         try { con = DriverManager..getConnection("jdbc:mysql://localhost/db",   “root” ,      “password@123$%^&*()_+    ");         
                Statement stmt  =con.createStatement();                     //Creating a statement       String sql="SELECT * FROM users WHERE userName = ? AND Password = ?";            pstmt .setString(1,username);               pstmt   setInt (2 , password)  ;                   int rowsInserted   =  stmt     executeUpdate()        } catch {          System.outprintln(" SQL Exception occurred… " +ex)}
                }}                 //end of method authFailureProc             });              };                  try{JDBCQueryHandler jh=new JDBCQuer  hi();jh .authFailureProc (“User Name”,  123456); } catch(Exception ex){ System.outprintln(" Exception Occurred… " +ex)}
               );         //end of try and catching the exception in main method           };}}              });    }}                Catching all SQLExceptions            EOF  (java)