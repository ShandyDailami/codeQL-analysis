import java.io.*;
import java.net.*;

public class java_09135_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); //listen on port 8080
        while (true) {
            Socket socket = serverSocket.accept(); // wait for client connection

            // Print out the client's IP address and port number
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected on port " + socket.getPort());

            // Send a response to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Client, you connected successfully!");
        }
    }
}