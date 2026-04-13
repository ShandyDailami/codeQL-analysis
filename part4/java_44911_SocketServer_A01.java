import java.io.*;
import java.net.*;

public class java_44911_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{        
        ServerSocket server = new ServerSocket(6013); // Port number is not recommended for production servers, this example uses a fixed port    
     
       System.out.println("Waiting on connection...");             
                
            Socket socket=server.accept(); 
            
           DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());   //Create Streams to send and receive data         
                BufferedReader inFromClient =new    BufferedReader (new InputStreamReader(socket.getInputStream()));     
                   String clientInput, serverResponse; 
                    while((clientInput=inFromClient.readLine()) != null){         //Read from the socket for input           System.out.println("Received: "+     Clientinput);            if(!clientInput .equalsIgnoreCase ("Exit")) {    Serverresponse ="Echo:" + clientInput;        outToClient.writeBytes(serverResponse     
                 += "\n");}}                    } catch (IOException e) {}  //Handle exception when something goes wrong during a connection   socket closing happens automatically by the garbage collector, or you can use finally to ensure close operations are done regardless of what happened in try/catch block             System.out.println("Client disconnected!");            serverSocketInstance_.close();     
     }                });  //Server shutdown when this program is closed    private static ServerSocket socket;   public         void main(String[] args) {        if (args.length != 2){           StdOut .println ("Usage: java MyServer <port> <filename>"); System halt;}          int port = Integer.,sockfile=Integer."" } catch {}
    eclipse/juno is not a valid file and can't be opened, Please provide the correct path.  I replaced your existing code with this one which only has basic socket server functionality in Java without any extra security features or operations related to access control like A01_BrokenAccessControl mentioned above: