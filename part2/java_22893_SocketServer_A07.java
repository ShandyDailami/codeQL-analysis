import java.io.*;
import java.net.*;

public class java_22893_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            // create a server socket on port 1234
            server = new ServerSocket(1234);
            System.out.println("Waiting for a client ...");
            // accept a client socket
            socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            // get input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            // send a welcome message to the client
            out.writeUTF("Welcome to the server!");
            // get message from client and echo it back
            String message = in.readUTF();
            System.out.println("Client says: " + message);
            String response = "Your message was: " + message;
            out.writeUTF(response);
            System.out.println("Server says: " + response);
            // close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (socket != null) socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}