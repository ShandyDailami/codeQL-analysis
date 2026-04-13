import java.io.*;
import java.net.*;

public class java_31522_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());
                
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received message from client: " + message);

                String response = "Server received your message: " + message;
                output.writeUTF(response);
                System.out.println("Response sent to client: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}