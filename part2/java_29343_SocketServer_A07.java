import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_29343_SocketServer_A07 {
    private static Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(4444, 0, InetAddress.getByName("localhost"));
            logger.info("Server started.");
            socket = serverSocket.accept();
            logger.info("Client connected.");
        } catch (Exception e) {
            logger.severe("Server could not start.");
            e.printStackTrace();
            System.exit(1);
        }

        // Create new threads for each client
        Thread clientThread = new Thread(new ClientHandler(socket));
        clientThread.start();
    }
}