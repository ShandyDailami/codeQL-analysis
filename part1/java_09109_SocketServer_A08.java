import java.io.*;
import java.net.*;
import java.util.*;

public class java_09109_SocketServer_A08 {
    private static int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        try {
            // 1. create a server socket and listen to port 8080
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // 2. Accept connection from client
            client = server.accept();
            System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected");

            // 3. create a data input stream and output stream
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // 4. read the message from the client
            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            // 5. send a response to the client
            String response = "Hello client, your message was received successfully!";
            dos.writeUTF(response);
            System.out.println("Sent response: " + response);

            // 6. close the streams
            dos.close();
            dis.close();

            // 7. close the socket
            client.close();
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}