import java.net.*;  
import java.io.*;  
public class java_52248_SocketServer_A07 {   
 private static String clients = ""; // List of connected client's ip address    
 public static void main(String args[]) throws Exception{     
 ServerSocket server=new ServerSocket(4446);  System.out.println("Waiting for incoming connection ...");  
 Socket socket;         
 while(true){          
 try {        // Accepts client and creates a new session    
socket =server.accept();    SetShutdownInput(socket);       BufferedReader reader=new BufferedReader((InputStreamReader(socket.getInputStream())));         String ip = socket.getInetAddress().toString();  clients +=ip+"\n"; //Add client's IP address to list     
 System.out.println("Client " + (clients));   Thread thread  = new ThreadedServer(socket);    thread.start();     } catch (Exception e) { socket.close(); continue;}       }}  void SetShutdownInput(Socket sock){ try{ SocketInputStream input =new     
SocketInputStream(sock); InputStreamReader reader=   //Read from client's IP address in string format          BufferedReader br =  new     buffreadersupportedreader("received: "+input.readline(),"UTF-8");    System.out..println((br .toString())); } catch (Exception e){ socket(      
!=null).close();}  }}   //Thread class for handling client's requests        public static void main() { try{ ServerSocket server =new      Socket("127.0.0",43856);    setshutdowninput"+server......}}          });
 } catch (Exception e) {}  }}   //Main method to initiate the program     };};}}}//End of code