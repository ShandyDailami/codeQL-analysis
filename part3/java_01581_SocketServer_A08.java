import java.io.*;
import java.net.*;

public class java_01581_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // create a ServerSocket on port 8080
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            // wait for client connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // read the message from the client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // send the message back to the client
            output.writeUTF("Server: Hello, Client!");
            output.flush();

            // close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close the server socket
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}