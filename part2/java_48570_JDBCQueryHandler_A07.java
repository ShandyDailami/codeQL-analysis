import java.sql.*;   // for all the sql operations   
public class java_48570_JDBCQueryHandler_A07 {    
 public static void main(String[] args){       
//Step1: Establish a Connection         
try{              
Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName","username", "password");           //replace with your database details     
System.out.println("Successfully connected to the SQL server!");        }  catch (Exception e){       System.err.println(e + "\nFailed connecting to sql-server.");         return;}    
//Step2: Prepare a Statement         
Statement stmt=con.createStatement();      //to perform CRUD operations           try{             String SQL = "SELECT COUNT (*) FROM Employee WHERE ID = 1";              ResultSet rs;            rs=stmt.executeQuery(SQL);               while (rs.next()){                int count  =   rs.getInt("ID");                 System.out.println ("Count:  " +count );}           }catch (Exception e) {System.err.println("\nFailed executing SQL Query"+e)}
//Step3 : Close all the resources          try{             con.close();                             stmt.close();                           } catch(SQLException se){    System.out.println("Closing connection " +se);   return;}     //finally clause finally block is used for cleanup      if(!con.isClosed()) {try{  conn.close();}catch ( SQLException se ) {}
//Step4: Exception handling          try{} catch(SQLException se){ System.out.println("Something went wrong" +se); }     //end of main function        }}