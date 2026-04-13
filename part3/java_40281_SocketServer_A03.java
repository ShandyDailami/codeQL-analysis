import java.io.*;
import java.net.*;
import java.util.*;

public class java_40281_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Write response
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello World");

            // Close connection
            socket.close();
        }
    }
}