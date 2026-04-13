import java.io.*;
import java.net.*;
public class java_53733_SocketServer_A08 {    
 public static void main(String args[]) throws Exception{        
        ServerSocket welcomeSocket = new ServerSocket(6013);         
       while (true){              
             Socket connectionSocket=welcomeSocket.accept();     
              DataInputStream inFromClient  =new 
DataInputStream(connectionSocket.getInputStream());          
                try {    
                    //Receive message from client  
                       byte[] bytes = new byte[1024];        
                      int bytesNumRead=inFromClient.read(bytes);     
                         if (calculateCheckSum(bytes,bytesNumRead)==false){   
                             System.out.println("Checksum Mismatch detected!" );          
                          }   else{  //print received message    
                           String message = new String(bytes ,0 , bytesNumRead);        
                            System.out.println ("Received: " +message );      
                         }     
                     connectionSocket.close();       
                }catch (Exception e){System.out.println("Error while receiving data");}         
               }            
           }    
   }  //end main   
 public static boolean calculateCheckSum(byte[] bytes, int len) {       byte sum = 0;      for (int i=0 ;i<len;i++){sum+=  bytes[i];}}        return ((sum & 0xff)-((long)(~sum&0xff))^-1)&255==(bytes.length*8/3); }
}       //end class SocketServer