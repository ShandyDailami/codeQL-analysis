import java.io.*;
import java.net.*;

public class java_14964_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080); // Bind to port 8080
            System.out.println("Server listening on port 8080...");

            while (true) {
                Socket client = server.accept();

                System.out.println("Accepted new connection from " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Echo: " + message);
                out.flush();

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}