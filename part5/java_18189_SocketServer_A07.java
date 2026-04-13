import java.io.*;
import java.net.*;
import java.util.*;

public class java_18189_SocketServer_A07 {
    private static final int PORT = 9090;
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";

    private static class SecureHandler implements Runnable {
        private Socket socket;

        public java_18189_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // First Handshake
                String clientIdentifier = in.readLine();
                if (!CLIENT_IDENTIFIER.equals(clientIdentifier)) {
                    out.writeBytes("AUTH_FAILURE\n");
                    socket.close();
                    return;
                }

                // Second Handshake
                out.writeBytes("OK\n");

                // Data Transmission
                String line;
                while ((line = in.readLine()) != null) {
                    out.writeBytes(line + "\n");
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Secure Socket Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            new Thread(new SecureHandler(socket)).start();
        }
    }
}