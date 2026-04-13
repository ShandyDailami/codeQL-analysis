import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24231_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT + ".");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_24231_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client's requests here. This is a very basic example and not a full-fledged server.
        try {
            // Read a message from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}