import java.io.*;
import java.net.*;
import java.util.logging.Logger;

public class java_17774_SocketServer_A07 {

    private static Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                logger.info("Waiting for connection on port " + port);
                Socket socket = server.accept();
                logger.info("Connection accepted from " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String message = in.readUTF();
                logger.info("Received message: " + message);
                out.writeUTF("Message received: " + message);
                out.flush();
                socket.close();
            }
        } catch (IOException e) {
            logger.severe("Error accepting client connection: " + e.getMessage());
        }
    }
}