import java.io.*;
import java.net.*;

public class java_25585_SocketServer_A01 {

    private static String USERNAME = "user";
    private static String PASSWORD = "password";

    public static void main(String args[]) {
        Socket socket;
        ServerSocket server;
        DataInputStream inFromClient;
        DataOutputStream outToClient;
        String clientInput;

        try {
            // Create the server socket and bind it to a port
            server = new ServerSocket(6789);
            System.out.println("Server started at port 6789");

            // Listen for client connections
            socket = server.accept();
            System.out.println("Client accepted from: " + socket.getRemoteSocketAddress());

            // Get streams for communication
            inFromClient = new DataInputStream(socket.getInputStream());
            outToClient = new DataOutputStream(socket.getOutputStream());

            // Authenticate the client
            clientInput = inFromClient.readUTF();
            if (clientInput.equals(USERNAME) && clientInput.equals(PASSWORD)) {
                outToClient.writeUTF("Successfully authenticated");
            } else {
                outToClient.writeUTF("Invalid credentials");
                socket.close();
                server.close();
              }

            // If authentication is successful, close the socket and server
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}