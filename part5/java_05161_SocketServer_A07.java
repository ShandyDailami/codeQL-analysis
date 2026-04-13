import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_05161_SocketServer_A07 {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public static void main(String[] args) {
        runServer(9999);
    }

    private static void runServer(int port) {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port);

            while (true) {
                System.out.println("Waiting for client connection...");
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected!");

                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(SSLSocket socket) {
        Objects.requireNonNull(socket);

        try {
            // Get the client's password
            socket.getInputStream().read();
            byte[] password = new byte[1024];
            socket.getInputStream().read(password);
            String userPassword = new String(password);

            // Check the password
            if (users.containsKey(userPassword)) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}