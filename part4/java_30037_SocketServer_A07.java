import java.io.*;
import java.net.*;

public class java_30037_SocketServer_A07 {

    private static final String SERVER_SOFTWARE = "Vanilla Secure Socket Server";
    private static final int PORT = 4445;
    private static Socket socket;
    private static ServerSocket server;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            server = new ServerSocket(PORT, 50, InetAddress.getByName("127.0.0.1"));
            System.out.println("Server started at port: " + PORT);
            while (true) {
                socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                // Start authentication here
                authenticateUser(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* cannot do anything, unless IOExceptions are not allowed */ }
            }
            if (server != null) {
                try { server.close(); } catch (IOException e) { /* cannot do anything, unless IOExceptions are not allowed */ }
            }
        }
    }

    public static void authenticateUser(Socket socket) {
        String clientMessage = null;
        try {
            clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);
            // For the sake of this example, we'll just return a fixed response
            out.writeUTF("Authentication successful!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
            } catch (IOException e) { /* nothing to do here */ }
        }
    }
}