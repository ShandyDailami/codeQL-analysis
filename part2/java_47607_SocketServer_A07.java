import java.io.*;
import java.net.*;
import javax.security.auth.*;
  
public class java_47607_SocketServer_A07 {    
    public static void main(String[] args) throws IOException, AuthenticationException{  //main method starts here     
        ServerSocket server = new ServerSocket();                     
        while (true){                                                  
            System.out.println("Waiting for client...");                
  
            Socket socket = server.accept();                         
            System.out.println("Client accepted");                     //Accept the incoming connection from a client 
                                                                    
           new AuthHandler(socket).start();                         //Start an authentication handler thread             
        }                                                             
    }}//closing main method         
  
class AuthHandler extends Thread{                                     
      private Socket socket;                                        
       public java_47607_SocketServer_A07(Socket s) {                              
            this.socket=s;}                                         
                                                                    
  @Override                                               
public void run(){                                            //Run the thread here                                             
    try {                                            
        BufferedReader in = new BufferedReader(new InputStreamReader ( socket.getInputStream()));   #Reading data from client side                      
         PrintWriter out=new PrintWriter (socket .getOutputStream(),true);                  
           String message,response;                            //Creating a string variable for the received and sent messages                    
            while((message = in.readLine()) !=  null){                         
              System.out.println("Received: "+message );                       #Prints out whatever is read from client side                     
                response=process(message);                              //Processing message as per requirement ie., simple authentication     
               if (response ==null || response .equals ("AuthFailure")){   #Check for Authentication failure, in case of successful login return null else "Authfailure" 
                 out.println("Authentication failed");                      }                                 
                System.out.println(message+"-->Send:" +response);         //prints the sent message and response from server         
              socket .getOutputStream().write((response).getBytes());     #Writes back to client side with processed data  
            }                                                                 
           out.close();                                            
    }}catch (IOException e){                                         
        System.out.println("Error in I/O operation "+e);                      //Prints the exception if any                           
         socket .close();                                        #Closes connection to client side                      
   });                                                              }  };//closing class AuthHandler here                  
    private String process(String message){                         //Process input data, this is a simple authentication function for test    
        return (message.equals("success")) ? null : "AuthFailure";      #If the received string equals to 'Success' then it will be returned as if there has been an auth failure else only Authfailure  
    }}//closing method process here         });                         //Closing class definition and main function