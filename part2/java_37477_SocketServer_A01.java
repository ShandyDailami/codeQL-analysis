import java.net.*;
import java.io.*;

public class java_37477_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            // create a socket and bind it to port 12345
            ServerSocket server = new ServerSocket(12345);
            System.out.println("EchoServer started on port 12345");
            
            // listen for client connections
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                
                // create new input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                // read data from client, and write it back to client
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);
                    out.writeUTF("Echo: " + message);
                    out.flush();
                    
                    // check if client disconnected
                    if (!message.equals("exit")) {
                        break;
                    }
                }
                
                // close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}