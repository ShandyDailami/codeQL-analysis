import java.io.*;
import java.net.*;

public class java_30000_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create a ServerSocket that listens on port 1234
            server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            // accept a client connection
            socket = server.accept();
            System.out.println("Client is connected");

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read a line from the client
            String line = in.readUTF();
            System.out.println("Received: " + line);

            // send a line back to the client
            out.writeUTF("Hello, Client!");
            System.out.println("Sent: " + "Hello, Client!");

            // close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}