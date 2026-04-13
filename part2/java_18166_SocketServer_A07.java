import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18166_SocketServer_A07 {

    private static final String LOCALHOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected!");

            // Check if connection is secure
            if (isConnectionSecure(socket)) {
                System.out.println("Connection is secure!");
            } else {
                System.out.println("Connection is not secure!");
                socket.close();
                continue;
            }

            // Handle client requests here
            // ...

            socket.close();
        }
    }

    private static boolean isConnectionSecure(Socket socket) {
        try {
            // Here, we are using SSLContext to authenticate the client.
            // SSLContext is created with a trust store that only allows localhost connections.
            // If you want to allow all connections, you can use InsecureSSLContexts.INSTANCE.
            SSLContext context = SSLContexts.custom()
                    .loadTrustMaterial(new File("path_to_truststore"),
                            "password_for_truststore",
                            "localhost")
                    .build();

            SSLServerSocket sockets = new SSLServerSocket(socket.getPort(), context,
                    SSLServerSocketOptions.create(InsecureSSLContexts.INSTANCE));
            return true;
        } catch (SSLException e) {
            e.printStackTrace();
            return false;
        }
    }
}