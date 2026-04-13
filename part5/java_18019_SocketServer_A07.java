import java.io.*;
import java.net.*;

public class java_18019_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 8888;
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Waiting for client connection on port " + port);

            socket = server.accept();
            System.out.println("Connected to client from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read data from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // send back data to client
            String response = "Hello from server";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

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