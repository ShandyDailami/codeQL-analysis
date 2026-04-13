import java.io.*;
import java.net.*;
public class java_51459_SocketServer_A03 { 
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(5000); //define port and create socket        
       while (true){          
            System.out.println("Waiting for client on Port: "+server.getLocalPort()+"..."); 
               Socket sock=server.accept();   //wait till connection   
              System.out.println(sock.getRemoteSocketAddress() + " just connected to port :" +  server.getLocalPort());                  
           new HandleClientThread(sock).start();//handle client request in a thread           
       }    
      }  //end of main   
}  
class HandleClientThread extends Thread{         
        Socket sock;        
             public java_51459_SocketServer_A03(Socket s) {              
                this.sock=s;             
           super.run();                 
                 try {                     
                     PrintWriter out = new PrintWriter (  sock.getOutputStream (), true);                  
                          BufferedReader in  =new   BufferedReader    (new InputStreamReader(sock.getInputStream()));         
                         String     clientmessage;              // declare string for incoming data        
                           while((clientmessage=in .readLine()) !=  null ){                 
                                System.out.println("Received: " + clientmessage);                  
                               out  .println ("Server : Message Received");                    
                            }                      sock.close();             });               //if exception then close socket           try {...} catch (Exception e) {}         
                 }}