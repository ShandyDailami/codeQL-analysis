import java.io.*;
import java.net.*;
import java.util.*;

public class java_10383_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Received message: " + clientMessage);

                String serverMessage = "Hello, client!";
                out.writeUTF(serverMessage);
                System.out.println("Sent message: " + serverMessage);

                socket.close();
            }
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