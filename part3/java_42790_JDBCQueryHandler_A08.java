import java.sql.*;   //Import necessary Java packages for DB operation like DriverManager, Statement etc..   

public class java_42790_JDBCQueryHandler_A08 {     //class declaration       
      public static void main(String[] args) throws SQLException{       //main method to run program        
           String url = "jdbc:mysql://localhost/test";  //Replace with your own database URL.         
           String username="root", password="password1234567890$#^&*()_+<>?";    // Replace these values by actual credentials for the MySQL server        
              Connection con = DriverManager.getConnection(url,username ,  password);       //Establish a connection to database         
           Statement stmt=con.createStatement();      //Create statement object       
             String sql;     //SQL query string that will be executed after the objects are created        
               /*In this example we assume two tables user and orders:*/  
            /** 1st table - User    */      
              sql = "CREATE TABLE `user` (\n" +\
                    "  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"+     //Auto increment field with unique id, primary key         
                     "  `name` varchar(50)\n," +  "\t//Name of the user \n  PRIMARY KEY (`id`)" +\    //Primary Key        
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";        /*Table creation sql query*/     
            stmt.executeUpdate(sql);     //Execute Create Table Statements  
           /**2nd table - Orders  */      
              sql = "CREATE TABLE `orders` (\n" +\             //Create another SQL Query for Creating a orders's data structure        
                     "  `idOrderedProducts` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"+     //Auto increment field with unique id, primary key         
                      " `productName` varchar(50),\t// Product name\n  PRIMARY KEY (`orderIdproducts>`)" +   //Primary Key          
                     ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";    /*Creating another table*/     
            stmt.executeUpdate(sql);     //Execute Create Table Statements again to create the second table       
             con.close();  //Close connection after use      
          }  
}