import java.io.*;
import java.net.*;

public class java_31351_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080); // bind socket to port 8080
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

            // accept the socket from a client
            socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read from the client
            String clientMessage = in.readUTF();
            System.out.println("Received from client: " + clientMessage);

            // send a response back to the client
            String serverMessage = "Hello, Client, thanks for connecting!";
            out.writeUTF(serverMessage);
            System.out.println("Sent to client: " + serverMessage);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}