import java.io.*;
import java.net.*;

public class java_31830_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create a server socket at port 1234
            server = new ServerSocket(1234);
            System.out.println("Waiting for client connection...");

            // accept a client connection
            socket = server.accept();
            System.out.println("Connected to client!");

            // get input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // read client's message
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // send back a reply
            message = "Hello, Client!";
            dos.writeUTF(message);

            // close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}