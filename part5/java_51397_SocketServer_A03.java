import java.io.*;
import java.net.*;
import javax.servlet.http.*;   // HttpServletRequest and friends have been deprecated since Servlets API v3, use the ones below instead if possible          

public class java_51397_SocketServer_A03 {   
     public static void main(String[] args) throws IOException  {      
          ServerSocket server = new ServerSocket (80);     
            System.out.println ("Waiting for client connection..." );       
         while(true){            
              Socket sock=server.accept();          
               try{                 
                    BufferedReader in  =new BufferedReader  
                     (new InputStreamReader(sock.getInputStream()));                
                   PrintWriter out = new PrintWriter   
                      (sock.getOutputStream(),true);            //automatic flushing done by this constructor            
        String inputLine;         
                    while ((inputLine=in .readLine()) !=  null){  
                        System.out.println ("Client: " + inputLine );    
                         if(isSafeInput (inputLine)) { 
                            out.println("Server :"+HtmlUtils.escapeHtml(inputLine));               //XSS prevention         
                         }       else{            
                             throw new IllegalArgumentException  
                              ("Received unsafe command:" + inputLine);       
                          };    
                     }          
                   sock.close();                 
                } catch (Exception e){                 System.out.println(e );    //Error handling     
               } 
          }      
      }           
   public static boolean isSafeInput(String command) {         if ((command != null ) && (! command .trim () .equals ("") ))        return true; else           false ;     };                  });             }}`    *Note:* This code will not function as expected without a server-side implementation to connect the client and perform an SQL injection attack.