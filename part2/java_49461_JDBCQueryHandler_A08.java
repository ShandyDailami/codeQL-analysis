import java.sql.*;   // for Java Database Connectivity(JDBC) API 
                   // and its classes such as Connection etc.   
public class java_49461_JDBCQueryHandler_A08 {    
        public static void main (String[] args){     
            String url = "jdbc:oracle:thin:@localhost:1521/xe";  
                       // database URL      
                    String userName="your_username ";            
                  // username to connect the DB   
                 String password="password";             
               // corresponding Password  for above UserID    
            try {     
                Connection con = DriverManager.getConnection(url,userName , password);  
                            // creating connection object with database through getconnection method of drivermanager class      
                        if (con != null)        {             System.out.println("Connected to Database Successfully");  }    else      {     println ("Could not connect the Databse" );          return;   };               // If connection is successful then only execute further         try{                    for(int i = 1 ;i<=50; i++){                            String sql = "insert into employee (id, name) values("+i+",'empName'" +i+")";                     con.createStatement().executeUpdate(sql);                       }   catch 
              SQLException ex    {           println ("Error in execution"  +ex );}             return;                  };                            //End of Try block          try{                   String sql = "select * from employee ";            ResultSet rs=con.createStatement() .executeQuery(sql);                     while (rs !=  null)                    System.out
              out.println("ID:  Name");                      int id;                        String name ;                       for (; rs.next();){                  id = rs.getInt ("id" );                          // Getting data from database                         println("\n ID : " + id  + "\t\tName :  = 
              ""+name);                                   }                            con.close ( )  }) catch(SQLException ex) {println("Error in closing connection: "   +  ex)};       };      }}`                     //End of Main method        });          it('should correctly handle the exception', function(){}());           return Jasmine, require(['jdbc'],function(){Jdbctest=require('./test.js');});   },