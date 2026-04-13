import java.io.*;
import java.net.*;

public class java_22941_SocketServer_A01 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create a ServerSocket and bind it to a port
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            // Step 2: Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client has connected...");

            // Step 3: Send a response to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Welcome to the server!");

            // Step 4: Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}