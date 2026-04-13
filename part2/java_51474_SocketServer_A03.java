import java.io.*;
import java.net.*;

public class java_51474_SocketServer_A03 {  
    public static void main(String[] args){    
        ServerSocket server = null;      // declare a new socket for the listener, that waits at port specified by arg        
       try{ 
           System.out.println("Waiting on Port: " +PORT);             
          PORT=Integer.parseInt(args[0]);    /* get first command line parameter as an integer */   //getting a random number from user, you could replace it with your code to securely generate the port     } catch (Exception e) {      System.out.println("Usage: Server <port>"); return; 
          try{ server = new ServerSocket(PORT);}catch (IOException ex){System.out.println("Unable To Listen on Port "+ PORT +". Maybe another program is using it?" );return;}   // create a listener to receive requests from clients     while(true) { Socket connection=null; try{ 
          System.out.println("\nWaiting for Connection..");    /* waiting till client establish the connection */       if((connection = server.accept()) != null )      Runtime.getRuntime().exec("cmd /c start echo Server Started... > nul "); // This is just a way to test, we will not be sending anything back or even receiving input    
          System.out.println("\nAccepting client at: "+connection.getRemoteSocketAddress());   /* print what the client says in terminal */    BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream()));  // Create a buffering character input stream for reading server's response
          System.out.println("Response: " +reader .readLine() );     } catch (IOException ex){System.err.println(ex); continue;}}    /* if there is any problem at this point, then we have lost the connection */  finally {if(server != null) try{ server.close();}catch(IOException e){ System.out.println("Error Closing Server"); } ;
          return;} catch (Exception $ex) {System.err.println($ex);}} // end of main method