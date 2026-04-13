import java.io.*;
import java.net.*;
public class java_42610_SocketServer_A01 {  
    public static void main(String args[]) throws IOException{ 
        String serverName = "localhost"; // Change this to your hostname or IP address if necessary        
        int port = 80;         
    	try (ServerSocket serverSocket = new ServerSocket(port)) {           System.out.println("Listening on Port: "+serverPort);  while((new Socket()).isConnected()){   String clientMessage="Client says : Hello World"; byte[] bytes=clientMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length , InetAddress.getByName(serverName), port);  serverSocket .send(packet ); }    		} catch (IOException e) { System.out.println("Couldn't get I/O for a connection");e.printStackTrace();}
    }}`   // End of Code snippet: remove the comment to start from here and continue until next task is assigned or an error occurs;  }; }