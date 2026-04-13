import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10711_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connections on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform authentication if necessary
                // For simplicity, we'll just check if the remote address is localhost
                if (socket.getRemoteSocketAddress().equals(socket.getLocalSocketAddress())) {
                    System.out.println("Authentication successful");
                } else {
                    System.out.println("Authentication failed");
                    socket.close();
                    continue;
                }

                // Handle the client connection in a separate thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_10711_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the request from the client
            // For simplicity, we'll just read the first line of the request
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();
            System.out.println("Received: " + request);

            // Send the response back to the client
            // For simplicity, we'll just send a greeting message
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}