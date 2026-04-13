import java.io.*;
import java.net.*;

public class java_45260_SocketServer_A01 {   // Server Socket Exception Handling Started from Here (line A1)    
    public static void main(String[] args){     
        try{           
             ServerSocket server = new ServerSocket(2000);  /// Defines the port on which our socket will run. Line B3       /////          Socket Connection Creation and Accepting Started from Here (line A4)        
              System.out.println("Server listening to Port: " + server.getLocalPort());     
               while(true){           /// Server Listening & Incoming Connections Block started From here  ///// Line B10            Socket Connection Accepting Started from Here (line A4)  
                    Socket socket = null;         
                      try{            
                           if((socket=server.accept())==null){               /// Condition to check whether the connection is not established properly or simply it's closed by client line B2  ///// Line C1              }            System.out.println("Connection Established with: " + socket.getRemoteSocketAddress());            
                           DataInputStream dis = new DataInputStream(socket.getInputStream());           /// Stream Creation and Reading Started from Here (line A6)   B2  /////                  try-catch block for the inputstream started here to catch any exceptions related              System.out.println("Input: " +dis .readUTF() );            }                    
                          finally{             socket.close();          /// Close Socket Connection Block Started from Here (line A10)           C2  /////                  try-catch block for the inputstream started here to catch any exceptions related              System.out.println("Connection Closed");         }}                   if(socket==null){                
                          socket.close();                                                       /// Exception handling in case of error or failure (line A16)           C2  /////                  try-catch block for the inputstream started here to catch any exceptions related              System.out.println("Failed To Establish Connection");         }}                     }                      while(true);            
        }           
          finally{ server.close();}     /// Close Server Socket Block Started from Here (line A14)   C2  /////                  try-catch block for the inputstream started here to catch any exceptions related              System.out.println("Server Stopped");         }}                   if(server==null){                      server .close();                                                       /// Exception handling in case of error or failure (lines B6 and A17) C2  /////                  try-catch block for the inputstream started here to catch any exceptions related              System.out.println("Failed To Establish Server");         }}