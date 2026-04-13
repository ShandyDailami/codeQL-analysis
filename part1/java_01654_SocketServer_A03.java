import java.io.*;
import java.net.*;

public class java_01654_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                outputStream.writeUTF("Connection established. Type your message and press return.");
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}