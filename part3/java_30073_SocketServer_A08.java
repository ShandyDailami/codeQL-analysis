import java.io.*;
import java.net.*;

public class java_30073_SocketServer_A08 {
    private static final int port = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create Server Socket
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Step 2: Accept Client Connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send Response
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}