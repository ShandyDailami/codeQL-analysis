import java.io.*;
import java.net.*;

public class java_36616_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Send a response to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, Client!");
        }
    }
}