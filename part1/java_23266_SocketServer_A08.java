import java.io.*;
import java.net.*;

public class java_23266_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive request
            String request = in.readLine();
            System.out.println("Received request: " + request);

            // Send response
            String response = "Hello, client!";
            out.writeBytes(response + "\r\n");
       
            socket.close();
        }
    }
}