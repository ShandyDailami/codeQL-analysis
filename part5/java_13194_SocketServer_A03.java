import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13194_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Start a new thread to handle the request
            new Thread(() -> handleRequest(socket)).start();
        }
    }

    private static void handleRequest(Socket socket) {
        // Here you can handle the request by reading from the socket and writing to the socket
        // For example:
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.println("Server received your message");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}