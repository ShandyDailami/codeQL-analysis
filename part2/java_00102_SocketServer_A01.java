import java.io.*;
import java.net.*;

public class java_00102_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Hand out a message to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("You've connected to the server!");

            // Reject all other connections
            socket.close();
        }
    }
}