import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05051_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Pass socket and security manager to new thread
                new HandleConnection(socket, new java.security.PermissionCollection()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleConnection extends Thread {
    private Socket socket;
    private java.security.PermissionCollection permissions;

    public java_05051_SocketServer_A07(Socket socket, java.security.PermissionCollection permissions) {
        this.socket = socket;
        this.permissions = permissions;
    }

    @Override
    public void run() {
        // Handle connection here
        // ...
    }
}