import java.sql.*;   // for SQL related classes   
public final class java_52590_JDBCQueryHandler_A01 {    
      private Connection conn;       // database connection object        
      public static String dbURL = "jdbc:mysql://localhost/test";       
      public static String username="root";            
      public static String password= 	"password1234567890!@#$%^&*()_+";   // replace it with your actual MySQL root user's pass     •.¸,;:..///.~`         .-._(/ the L
public VanillaJDBCQueryHandler(){      try {          conn = DriverManager.getConnection(dbURL ,username ,password);    } catch (SQLException ex)        // Handle exception by printing out an error message       System.out.println("Error in establishing connection: " +ex );     return;   }}