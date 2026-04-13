import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_29447_SocketServer_A01 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        int port = 1234;

        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                LOGGER.log(Level.INFO, "Client connected: {0}", client.getRemoteSocketAddress());

                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                out.write("Hello, World!\n".getBytes());
                out.flush();

                byte[] buffer = new byte[1024];
                int bytes = in.read(buffer);
                if (bytes == -1) {
                    LOGGER.log(Level.WARNING, "Client disconnected");
                } else {
                    LOGGER.log(Level.INFO, "Received: {0}", new String(buffer, 0, bytes));
                }

                client.close();
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}