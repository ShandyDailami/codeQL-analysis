import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_11015_SocketServer_A03 {
    public static void main(String[] args) {
        boolean isSecure = true;
        int port = 8080; // default port
        if (args.length == 1) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number: " + args[0]);
                System.exit(1);
            }
       <｜begin▁of▁sentence｜>
        // Check if the port is already in use
        ServerSocket serverSocket = null;
        try {
            serverSocket = (ServerSocket) new SSLServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        }

        while (true) {
            try {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getInetAddress().getHostAddress());
                // Process the socket here.
                // e.g. start reading data from the client, write response, etc.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}