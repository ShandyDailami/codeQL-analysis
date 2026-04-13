import java.io.*;
import java.net.*;

public class java_05726_SocketServer_A08 {

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            server = new ServerSocket(1234); // listening on port 1234
            System.out.println("Waiting for a client...");

            // waiting for a client
            socket = server.accept();
            System.out.println("Connected to the client");

            // creating a data output stream
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // sending a message to the client
            outputStream.writeUTF("Hello Client, you are authenticated!");

            // closing the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // closing server socket
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