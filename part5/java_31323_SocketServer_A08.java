import java.io.*;
import java.net.*;

public class java_31323_SocketServer_A08 {
    private static final int port = 1234;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received request: " + request);

                // Example of security-sensitive operation:
                if ("INTEGRITY_FAILURE".equals(request)) {
                    out.writeUTF("Security violation detected. Denying connection.");
                    out.flush();
                    socket.close();
                    continue;
                }

                out.writeUTF("Handling request: " + request);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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