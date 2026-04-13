import java.net.*;
import java.io.*;

public class java_03389_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080; // default port
        Socket socket = null;

        try {
            // create a server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // accept a client socket
            socket = serverSocket.accept();
            System.out.println("Client accepted: " + socket.getRemoteSocketAddress());

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // receive a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // send a response to the client
            String response = "Hello, client!";
            out.writeUTF(response);

            // close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}