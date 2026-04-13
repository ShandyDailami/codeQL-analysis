import java.io.*;
import java.net.*;
import java.util.*;

public class java_07837_SocketServer_A07 {
    private static final int port = 12345;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                OutputStream out = new BufferedOutputStream(client.getOutputStream());
                DataOutputStream writer = new DataOutputStream(out);

                // Authentication
                writer.writeUTF("Please provide a username and password:");

                InputStream in = new BufferedInputStream(client.getInputStream());
                DataInputStream reader = new DataInputStream(in);

                String username = reader.readUTF();
                String password = reader.readUTF();

                // Check username and password for security sensitive operations
                if (username.equals("admin") && password.equals("password")) {
                    writer.writeUTF("Authentication successful!");
                } else {
                    writer.writeUTF("Authentication failed!");
                }

                writer.flush();
                client.close();
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