import java.io.*;
import java.net.*;

public class java_47225_SocketServer_A08 {   //Class Name should be descriptive and match the task, e.g "A08_IntegrityFailureSolution" instead of 'Secured Socket Server' (as it might imply a security breach) 
    private static final int PORT = 4567;    
                              // Choose an arbitrary unprivileged port to avoid conflicts with existing services.     
  
    public java_47225_SocketServer_A08() {       
         try{                          
               ServerSocket server = new ServerSocket(PORT);      
                   System.out.println("Securing socket on "+ PORT );  //Display message indicating the start of connection    
              while (true)                      {     
                Socket client  =server .accept();           
                    PrintWriter out = 
                         new PrintWriter (client.getOutputStream(), true);      
                        BufferedReader in =  
                            new BufferedReader(new InputStreamReader(client.getInputStream()));    
                     String message, response;      //Declare and initialize variables for the communication   
                      do {          try{         if ((message  =in .readLine()) == null ) break;}  catch (IOException e){e.printStackTrace();}      
                    } while(true);        System.out.println("Client Connected");     //Display message indicating client connection     
            out.println ("Server Response from Client: Hello User, your data is secure! ");    response= in .readLine ( );   if (!response.equals("Exit"))  {System.exit(0);}         } catch (IOException e){e.printStackTrace();}}     //catch and handle exception     
            finally{ server.close(); System.out.println ("Server Stopped"); }}          try {}    private java_47225_SocketServer_A08(){}        public static void main  ([String... args]) { new   SecureSocketServer ();} });              } catch(IOException e){e .printStackTrace();}}