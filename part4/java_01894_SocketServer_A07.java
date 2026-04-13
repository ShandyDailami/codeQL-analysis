import java.io.*;
import java.net.*;

public class java_01894_SocketServer_A07 {
    private static String USERNAME = "user";
    private static String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(6789);
            System.out.println("Server is listening on port: 6789");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String client_username = in.readUTF();
                String client_password = in.readUTF();

                if (client_username.equals(USERNAME) && client_password.equals(PASSWORD)) {
                    out.writeUTF("Authentication successful!");
                    out.flush();
                } else {
                    out.writeUTF("Authentication failed!");
                    out.flush();
                }

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