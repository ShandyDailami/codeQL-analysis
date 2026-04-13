import java.net.*;
import java.io.*;

public class java_35316_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 12345;
        try {
            // create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // accept a client socket
            Socket client = server.accept();
            System.out.println("Client accepted from " + client.getRemoteSocketAddress());

            // create an input stream
            DataInputStream dis = new DataInputStream(client.getInputStream());

            // read a message from the client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // create an output stream
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // send a message back to the client
            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            // close the connection
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}