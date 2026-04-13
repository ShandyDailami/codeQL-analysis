import java.io.*;
import java.net.*;
import java.util.logging.*;

public class java_15080_SocketServer_A01 {
    private static final Logger LOG = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(12345);
            LOG.info("Server started on port 12345");

            while (true) {
                socket = serverSocket.accept();
                LOG.info("Client connected from: " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String response = "Welcome to the server!";
                out.writeUTF(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}