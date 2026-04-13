import java.io.*;
import java.net.*;

public class java_26607_SocketServer_A08 {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(5000); // listening port
            System.out.println("Server is listening on port 5000");

            while (true) {
                socket = serverSocket.accept(); // waiting for client
                System.out.println("Client connected");

                // read from the client
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                // write to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String serverMessage = "Hello Client, Your data has been received.";
                out.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close(); // end session with the client
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close(); // close the server socket
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}