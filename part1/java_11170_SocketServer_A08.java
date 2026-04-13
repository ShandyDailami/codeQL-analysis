import java.io.*;
import java.net.*;

public class java_11170_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for connection on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Send a response
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeBytes("HTTP/1.1 200 OK\r\n\r\n");

            // Close the connection
            socket.close();
        }
    }
}