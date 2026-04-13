import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28417_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Here you would typically handle multiple connections in a separate thread.
                // However, for the sake of simplicity and for a A08_IntegrityFailure example, we'll keep it simple here.
                handleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Implement your request handling here.
        // For simplicity, we'll just read a line from the socket and print it back.
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println("Received: " + line);

            // Here you would typically write a response back.
            // For the sake of simplicity, we'll just send a simple response.
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Server received your message: " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}