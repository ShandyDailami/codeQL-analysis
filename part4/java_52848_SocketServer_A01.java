[Snippet]
import java.io.*;
import java.net.*;
  
public class java_52848_SocketServer_A01 {     // Server Side Program   
 public static void main(String args[]) throws Exception{        
 Socket s = new Socket("localhost",1234);         
 System.out.println ("Client has been connected to the server");          
 OutputStream out=s.getOutputStream();               
 DataOutputStream dout=new DataOutputStream(out);            // Create data output stream    
 String msgToSend="Hello World";                     
 byte b[] =msgToSend.getBytes ( );                
 int count;                                         
 
 System.out.println ("Sending a message to the client");                   for (; ; ) {              try{ dout .writeUTF( new String((byte)b)); }catch("e")                catch ((Exception e){ break;}                     while (!s.isClosed() && (count = s.getInputStream().read()) != -1 
                  );                                                                            System.exit(0);                            }}                                                    });                   // Close the connection if it is open           SocketConnection socketconnection;                 try {socketclientconnexion! :                     } catch{break;}       `})));}})))))