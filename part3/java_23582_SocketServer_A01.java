import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23582_SocketServer_A01 {
    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read from client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Send back to client
                out.println("Echo: " + message);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}