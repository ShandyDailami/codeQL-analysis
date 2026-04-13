import java.io.*;
import java.net.*;
import java.util.*;

public class java_25608_SocketServer_A08 {
    private static final String USERNAME = "secureServer";
    private static final String PASSWORD = "secureServerPassword";

    private static boolean areCredentialsValid(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    private static Socket createSocket(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();

        if (!areCredentialsValid(socket.getRemoteSocketAddress().getHostName(), socket.getInputStream().readUTF())) {
            socket.close();
            return null;
        }

        return socket;
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Server started");

            while (true) {
                Socket socket = createSocket(serverSocket);

                if (socket != null) {
                    new Thread(() -> handleRequest(socket)).start();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void handleRequest(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String request = reader.readLine();
            System.out.println("Received: " + request);

            if ("exit".equals(request)) {
                writer.println("Exiting");
                socket.close();
                return;
            }

            writer.println("Hello, client");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}