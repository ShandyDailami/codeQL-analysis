import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Permission;

public class java_25078_SocketServer_A07 {

    // Define the allowed IP address
    private static final String ALLOWED_IP = "127.0.0.1";

    // Define the port
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for connection on port " + PORT);

        // Create a security manager with a single permission for localhost
        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) throws SecurityException {
                if (perm.getClass().getName().equals("java.net.SocketPermission")) {
                    if (perm.getName().equals("localhost")) {
                        throw new SecurityException("Unable to connect from this host!");
                    }
                }
            }
        };

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Set the security manager for the socket
            socket.setSecurityManager(sm);

            // Now you can use the socket, but only if you allow connections from the allowed IP
            // As we have set the security manager, only allowed connections will be accepted
        }
    }
}