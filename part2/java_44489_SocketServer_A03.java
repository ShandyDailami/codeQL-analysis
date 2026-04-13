import java.net.*;
public class java_44489_SocketServer_A03 {  
    public static void main(String args[]){    
        try{      
            // Create socket server on defined Port         
            ServerSocket s=new ServerSocket(7500);            
               System.out.println("Waiting for client connection...");          
              Socket incoming=s.accept();        
                String message;  
                 do {   
                    byte[] bytes=incoming.getInputStream().readNBytes(1024) ;         
                     Message = new String (bytes,"UTF-8")     
                      System.out.println("Received: "+Message);           }while (!message .equals ("Quit"));       // If message is not Quit, read next    });  s.close();    
        catch(Exception e){         System.out.println (e) ;   }}      Connection refused : Server doesnt exist or there are too many clients attempting to connect at the same time: Address already in use by another method... }catch block still runs even when exception is thrown  */ });    s . close();
}}     catch(Exception e){ System.out.println (e) ; }}