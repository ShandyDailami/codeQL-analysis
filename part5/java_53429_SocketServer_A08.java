import java.io.*;   // Input / Output Streams & Buffered Reader in particular     
import java.net.*;    // Server Socket, InetAddress (IPv6 addresses) etc         
      
public class java_53429_SocketServer_A08 {    
        public static void main(String[] args){ 
            try{                    
                SSLServerSocket server = new SSLServerSocket();            
                
                System.out.println("Waiting for client connection... ");   // wait until a request comes from the Client                 
                                                           
                Socket sock=server.accept();                         // Accepts incoming requests     
                                 
               BufferedReader in = new BufferedReader(new InputStreamReader (sock.getInputStream()));  /* Create an input stream reader to read data sent by client */   
                                                                      
                                                            socket.close()   ;                  /* Close the existing connection and exit*/    
                } catch Exception e {e.printStackTrace();}      // Print exception details if any        finally{ serverSocket.*; }}  this will not work without proper implementation for ssl connections or with other exceptions as well which are beyond your request    Here I have provided a minimal code to complete the task and you can add more features based on requirement, but be aware of security risks involved in such tasks.
               }   // End try block       catch (Exception e) { /* Handle exception */ };  finally{ if(server != null){ server.close(); }} ;    });     sock =null;}}      BufferedReader br  =null;}         PrintWriter out=  null;        String line =  "";
               int i  = 0, read_size = 0; char[] chars = new byte[128];  // Char buffer of size defined by your requirements.       while((read_size=in.read(chars)) ! -1){     try{ out  =new PrintWriter (sock.getOutputStream(), true);    for(i = 0; i < read_size ; i++) {out .println ("Received: " + chars[i]);}} catch Exception e   {} finally{}  }      if(!serverSocketIsClosed){ serverSocket.close(); }}
            sock = null;}     br  =null, out =  null;    String line="";try{ in    =new BufferedReader( new InputStreamReader (sock .getInputStream())); while((line=  in_.readLine())!-1 ) { try   {  System.out-.println("Message from Client : " + line); } catch Exception e {} finally{}    }}catch块必须包含在try/finally的括号内，以确保无论是否发生异常都会执行相应的过程。
            sock = null; br  =null, out=null;}     if(!serverSocketIsClosed){ server_socket.close();}}   } catch (Exception e) { /* Handle exception */ };  finally{if(sock!=  null )    try{ socket .close()}catch Exception ex {}finally{} ; }}