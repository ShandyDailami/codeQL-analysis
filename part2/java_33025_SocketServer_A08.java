import java.io.*;
import java.net.*;

public class java_33025_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started at port 8000...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 1: Send back a welcome message
            out.writeUTF("Welcome to the SocketServer example program. Please provide your name!");

            // Step 2: Request the client's name
            String clientName = in.readUTF();
            System.out.println("Client name: " + clientName);

            // Step 3: Send a greeting message back to the client
            out.writeUTF("Hello, " + clientName + ". How are you today?");

            // Close the connections
            socket.close();
       
        }
    }
}