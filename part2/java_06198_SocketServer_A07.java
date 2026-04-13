import java.io.*;
import java.net.*;
import java.util.*;

public class java_06198_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(1234); // port number
            System.out.println("Server is running and waiting for client connection...");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientUsername = in.readUTF();
                String clientPassword = in.readUTF();

                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    out.writeUTF("Connection successful");
                } else {
                    out.writeUTF("Connection failed");
                    socket.close();
                    continue;
                }

                out.close();
                in.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}