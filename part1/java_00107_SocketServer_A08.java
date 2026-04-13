import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_00107_SocketServer_A08 {

    private static final Logger LOG = Logger.getLogger(SecureSocketServer.class.getName());

    private static final int PORT = 8080;
    private static final String PASSWORD = "securePassword";

    public static void main(String[] args) {
        InetAddress address = null;
        ServerSocket server = null;
        try {
            address = InetAddress.getByName("127.0.0.1");
            server = new ServerSocket(PORT, 10, address);
            server.setReuseAddress(true);
            LOG.log(Level.INFO, "Server is running on port {0}", PORT);

            while (true) {
                Socket socket = server.accept();
                LOG.log(Level.INFO, "Client {0} connected", socket.getRemoteSocketAddress());

                new SecureSocketHandler(socket).start();
            }
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error accepting connection", ex);
        } finally {
            try {
                server.close();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Error closing server", ex);
            }
        }
    }

    private static class SecureSocketHandler extends Thread {

        private Socket socket;

        public java_00107_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.getInputStream().close();
                socket.getOutputStream().close();
                socket.close();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Error closing socket", ex);
            }
        }

    }

}