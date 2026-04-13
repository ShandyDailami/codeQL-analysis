import java.io.*;
import java.net.*;
import java.util.*;

public class java_41787_SocketServer_A08 {
    private static int DEFAULT_PORT = 8888;
    private ServerSocket server;

    public static void main(String[] args) throws IOException {
        new SecureSocketServer().startServer(DEFAULT_PORT);
    }

    private void startServer(int port) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while(true) {
            Socket socket = server.accept();
            System.out.println("Accepted new client at: " + socket.getRemoteSocketAddress());

            handleClient(socket);
        }
    }

    private void handleClient(Socket socket) {
        try {
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String clientMessage;

            while((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                writer.println("Echo: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to handle client: " + e.getMessage());
        }
    }
}