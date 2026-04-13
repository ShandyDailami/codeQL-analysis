import java.net.*;
import java.io.*;

public class java_14367_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            // Create a new server socket
            ServerSocket serverSocket = new ServerSocket(8080);

            while(true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Create new input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Read request from client
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Send response to client
                out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                out.writeBytes("Hello, client\r\n");

                // Close the connection
                clientSocket.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}