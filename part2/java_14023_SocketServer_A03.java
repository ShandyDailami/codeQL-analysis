import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14023_SocketServer_A03 {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port + ".");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                handleRequest(clientSocket);
            }
        } catch (IOException ex) {
            System.out.println("Error in server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            int request;
            while ((request = in.read()) != -1) {
                out.write(request);
                out.flush();
            }
        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}