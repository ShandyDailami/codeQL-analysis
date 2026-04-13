import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38253_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client connected from " + socket.getRemoteSocketAddress());

                // Handle the connection in a separate thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_38253_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            java.io.BufferedReader in = new java.io.BufferedReader(
                    new java.io.InputStreamReader(socket.getInputStream()));
            java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);

            // Send a greeting message
            out.println("Hello, client!");

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Echo back the message
                out.println("Echo: " + message);
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}