import java.io.*;
import java.net.*;

public class java_39999_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Server socket setup
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        while (true) {
            // Accepting client connection
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

            // Creating output stream for client
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Realistic and creative security-sensitive operation
            // (i.e., A07_AuthFailure, in a legacy style)
            outputStream.writeUTF("Hello, client, you are authenticated!");

            // Closing the output stream and the socket
            outputStream.close();
            socket.close();
       
            System.out.println("Connection closed");
        }
    }
}