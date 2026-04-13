import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_44378_SocketServer_A01 {  
    public static void main(String[] args) throws Exception 
    {    
        SSLServerSocket serverSocket = null;          // Declare a new instance of the Server Socket Class     
        
        try{            
            // Step1: Create an object for listening on port no. '9876' with enabled protocol as TLSv2 and enable client authentication  
            SSLServerSocket serverSSLSock = (SSLServerSocket)serverSocket.accept();    #  Accepts incoming connections using the Server Socket Class, enabling use of security protocols       // Step1_END     
            
        }catch(Exception e){                         /// In case any exception occurs during above process show an error message on console            catch block             
                System.out.println("Failed to setup SSL: " +e);  # Error Message                      Console printing the caught Exception     try-except clause          // Step2_END        
        }   finally{                               /// Clean up resources at end of operation, like closing Server Socket here    Finally block              e.printStackTrace();                     catch and finalize are not needed in this context as we only have a single statement inside the 'try' where exception handling is handled  // Step3_END        
        }  
          sslServerSocket = (SSLServerSocket) serverSSLSock .accept( );       # Accepts incoming connections using SSL Server Socket Class, enabling use of security protocols.      catch block               System Out Printing the caught Exception     try-except clause  // Step4_END         }                                                                                           
}