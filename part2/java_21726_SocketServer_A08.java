import java.io.*;
import java.net.*;

public class java_21726_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");
        
        while(true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");
            
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Response sent to client: " + response);

            socket.close();
        }
    }
}