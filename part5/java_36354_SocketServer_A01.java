import java.io.*;
import java.net.*;

public class java_36354_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive and echo message from client
            String message = in.readLine();
            System.out.println("Received: " + message);
            out.writeBytes("Echo: " + message + "\n");

            // Close the socket and release resources
            socket.close();
        }
    }
}