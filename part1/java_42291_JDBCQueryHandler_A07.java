import java.util.*;  // Importing Scanner class java_42291_JDBCQueryHandler_A07 taking inputs  
class Main {   
// Driver code    
public static void main(String[] args) throws Exception{     
Scanner s = new Scanner (System.in);         System.out.println ("Enter Username: ");          String username=s.next();       //username credentials from user        System.out.print("\n Enter Password :");     String password=  s.next() ;    boolean flag =  false;     
do {   try{  Connecting to database//here we are assuming that the method 'getConnection' of ConnectionFactory class returns a connection object       JDBCConnection con= (JDBCConnection)ConnectorFacade .getInstance().getConnection(user,password);          //Establish connections       
System.out.println ("You have successfully connected to database");             flag = true;     }catch (Exception e){               System.err.format("Failed to connect: %s",e.getMessage());         }}while(flag==false)   ;  Connection con=null;} //closing the connection   
finally{if(con!= null ) { try{con.close();} catch(SQLException se){}}; in this block we are ensuring that our connections get closed if an error occurs during execution, which is good practice to follow for managing resources properly and preventing resource leaks/hangs } 
// end of the program         }} // Closing statement    System.out.println ("Successfully logged out");      });}};