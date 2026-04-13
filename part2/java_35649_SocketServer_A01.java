import java.net.*;
import java.io.*;

public class java_35649_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Waiting for client on port 8080");

            socket = serverSocket.accept();
            System.out.println("Client accepted. Socket created");

            // Create a new stream for communication with client
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage;

            // Read from client
            clientMessage = dis.readUTF();
            System.out.println("Received: " + clientMessage);

            // Send back a message to client
            dos.writeUTF("Hello, Client, thanks for connecting to my server!");
            dos.flush();

            // Close the streams and the socket
            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();

            System.out.println("Server closed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}