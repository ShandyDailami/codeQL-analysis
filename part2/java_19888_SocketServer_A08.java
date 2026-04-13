import java.io.*;
import java.net.*;

public class java_19888_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // create a server socket
            serverSocket = new ServerSocket(1234);
            System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());

            // accept a client connection
            socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read a message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // send a response back to client
            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            // close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}