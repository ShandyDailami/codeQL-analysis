import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_36307_SocketServer_A01 {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for connection...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Here's the Broken Access Control line
            byte[] b = new byte[1];
            input.read(b);

            // Continue the rest of the code...
            // Here, we're trying to read more data than we've sent, which is a Broken Access Control operation
            // By reading more data than we've sent, we're inadvertently writing more data to the socket, which is not allowed
        }
    }
}