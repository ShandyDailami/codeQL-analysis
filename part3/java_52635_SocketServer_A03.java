import java.io.*;  // for InputStream, OutputStream classes  
import java.net.*;  // for ServerSocket and Socket classes   

public class java_52635_SocketServer_A03 {    
// define port number to use (can either hard code or retrieve from a config file)      
private static final int PORT = 1234;     
          
        public static void main(String[] args){         // the entry point of any Java program         
            try{   
                ServerSocket server = new ServerSocket(PORT);     // listen on port 8097             
                         System.out.println("Server listening...");      
                     while (true) {  
                        Socket socket = server.accept();            
                              Thread thread =  new MyThread(socket);         
                               thread.start();                            }     
            // code to handle exceptions, if any occurs at this point        catch block will not be executed  here          
                 ServerSocketExample example=new ServerSocketExample("localhost",PORT+10 );  
                System.out.println ("Server started with host: " +example .getHostName()+  ", port:" +  String.valueOf( PORT ));       }              catch (IOException e) {     // handle IOExceptions      printStackTrace();    }}  */}})         ;