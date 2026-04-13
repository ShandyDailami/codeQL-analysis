import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_24509_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // create server socket with port 8080
            serverSocket = new ServerSocket(8080);
            logger.log(Level.INFO, "Server started on port: " + 8080);

            // wait for client connection
            socket = serverSocket.accept();
            logger.log(Level.INFO, "Client connected: " + socket.getInetAddress().getHostAddress());

            // create input and output stream
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // read data from client
            byte[] bytes = new byte[1024];
            int bytesRead = inputStream.read(bytes);
            String data = new String(bytes, 0, bytesRead);
            logger.log(Level.INFO, "Received data: " + data);

            // send response back to client
            String response = "Thank you for connecting, data received: " + data;
            outputStream.writeUTF(response);
            logger.log(Level.INFO, "Sent response: " + response);

            // close connection
            outputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error occurred: " + ex.getMessage(), ex);
        }
    }
}