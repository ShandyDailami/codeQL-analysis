import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13026_SocketServer_A08 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Here, the server assumes the client is trustworthy and only forwards
                // the request to a handler, which is implemented in the handler thread
                // (HandlerThread in this case).
                // In a real-world scenario, the server would also need to verify the identity
                // of the client and ensure the client is requesting a resource that the server
                // is willing to serve. This would involve SSL/TLS for security, and the use of
                // certificate-based authentication for A08_IntegrityFailure.
                // HandlerThread handler = new HandlerThread("SocketServer-Handler-" + i);
                // handler.start();
                // new SocketRequestHandler(socket, handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}