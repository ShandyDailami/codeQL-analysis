import java.io.*;
import java.net.*;

public class java_28347_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client connection...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received message: " + message);
            // Simulating a security violation here
            if (message.equals("BAD_COMMAND")) {
                System.out.println("Broken access control violation!");
                out.println("Access denied");
            } else {
                out.println("Message received, processing...");
           
            }
        }
        socket.close();
        serverSocket.close();
    }
}