import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29740_SocketServer_A08 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for handling each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_29740_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            socket.getInputStream();
            socket.getOutputStream();

            // Handle the request for the client
            // Here we just echo the client's message back to them
            socket.getInputStream().read();
            socket.getOutputStream().write(socket.getInputStream().read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the connection when done
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}