import java.io.*;
import java.net.*;

public class java_12706_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            // Create streams for reading and writing
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a greeting message
            out.writeUTF("Hello, client!");

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Server received: " + message);

            // Close the streams
            out.close();
            in.close();
            socket.close();
       
            // Wait for a while before accepting new connections
            Thread.sleep(1000);
        }
    }
}