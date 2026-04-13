import java.io.*;
import java.net.*;

public class java_13018_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            // Step 1: Setup server socket
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is running on port 4444");

            // Step 2: Accept a client socket
            socket = serverSocket.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            // Step 3: Get input and output streams
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            // Step 4: Read from client
            String clientMessage = input.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Step 5: Send back to client
            String serverMessage = "Hello, Client!";
            output.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            // Step 6: Close connection
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Cleanup resources
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}