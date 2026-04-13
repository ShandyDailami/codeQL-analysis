import java.io.*;
import java.net.*;
import java.util.*;
  
public class java_45308_SocketServer_A08 {    
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket();      // step a: create the server socket           
        
        try{            
           System.out.println("Waiting for connection on port " +   server.getLocalPort()+"...");   
          Socket clientSocket=server.accept();       //step b & c : accept clients request and get connected to it 
               
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);     // step d: create output stream connection        
            
           BufferedReader in =new BufferedReader (                                                           
                     new InputStreamReader (clientSocket.getInputStream()));                          
                       
          String line;                                                                                   
          while((line=in.readLine()) != null){              /*step e*/    //Receive message from client      
            System.out.println("Received: "+line); 
            
           if(isValidRequestBasedOnIntegrityFailureCheckingAlgorithm(line)){                         // step f, a creative and realistic approach to integrity checking - do not say sorry!   
              out.println ("Response for valid request");                                         
            }else{                                                                                     /*step g*/  
             System.out.print("Error: Invalid Request received!");    
           } 
          };        //end while loop      
         finally { server.close(); clientSocket.close();}      // step h, always make sure to close your end points when possible   
           
        }finally{server.close()};                                                         /*step i*/   //Ensure that the socket is closed in any case  (either gracefully or abruptly)    
       };//end of main method                                                                     
         private static boolean isValidRequestBasedOnIntegrityFailureCheckingAlgorithm(String request){         
           try{                                         
             byte[] bytes =request.getBytes();                                                     // step a, use standard library to calculate SHA256 hash and compare it with received data 
              MessageDigest md=MessageDigest.getInstance("SHA-256");                              /*step b*/   
               byte[] thedigest =  md.digest(bytes);                                                  // step c (use standard library) to calculate SHA hashing  
             return Arrays.equals(thedigest, hexStringToByteArray(request));                      // returns whether two data are equal or not  , do no apologize!    
            }catch (Exception e){                                                                                       /*step d*/    ExceptionHandlerHereOrMoveOnNextLineForReadabilityAndCleanlinessOfYourCode.printStackTrace();                                                            return false;}}   catch(Throwable t) {t.printStackTrace();return false;}              };  //end of private method
         
         public static byte[] hexStringToByteArray (String s)                                /*step e*/    {{                                                                                     
             int len = s.length() / 2;                // step f   Convert the hex string into bytes     returnArr=new                        String(hexStrings);                                  };}}                          ;return returnArr;}                                                             */};//end of private method      }        /*step h*/}}}