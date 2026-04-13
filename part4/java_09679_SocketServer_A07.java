import java.net.*;
import java.io.*;

public class java_09679_SocketServer_A07 {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;

        try {
            server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000...");

            while (true) {
                socket = server.accept();
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                // Write a response to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello client, you are now connected to server!");

                // Close the connection
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}