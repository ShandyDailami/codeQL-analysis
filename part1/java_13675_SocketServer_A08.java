import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_13675_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        int port = 8080;
        boolean ssl = true;

        ServerSocket serverSocket = null;
        try {
            if (ssl) {
                serverSocket = (SSLServerSocket) new SSLServerSocket(port);
                InetAddress address = InetAddress.getByName("localhost");
                serverSocket.bind(address);
                logger.log(Level.INFO, "Bound to " + address.getHostAddress() + " on port " + port);
            } else {
                serverSocket = new ServerSocket(port);
                logger.log(Level.INFO, "Bound to port " + port);
            }

            while (true) {
                Socket socket = serverSocket.accept();
                handleRequest(socket);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception occurred", ex);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static void handleRequest(Socket socket) {
        // Create a new thread for each client socket
        Thread thread = new Thread(new SocketHandler(socket));
        thread.start();
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_13675_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add your custom code related to the client socket
            // For example, you can read data from the client, send data to client, etc.
            // But please note this part is only for demonstration purposes, the actual implementation may be different

            // Here we assume that the client sends a message and we reply with a message back to the client
            socket.getInputStream().read();
            socket.getOutputStream().write("Hello client".getBytes());

        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception occurred", ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Exception occurred", ex);
            }
        }
    }
}