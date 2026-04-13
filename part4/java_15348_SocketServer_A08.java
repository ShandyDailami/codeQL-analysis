import java.io.*;
import java.net.*;

public class java_15348_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create Input Stream from socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send response to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Thank you for connecting to server");

            // Handle client input
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                out.println("Echo: " + request);
            }

            socket.close();
        }
    }
}