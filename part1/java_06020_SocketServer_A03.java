import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06020_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the connection in a separate thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for connections");
            e.printStackTrace();
       
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_06020_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // In the future, we might want to handle multiple clients concurrently
        // In the meantime, we'll just assume that the server will only handle one client at a time

        // Read from the client
        // ...

        // Close the connection
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Error while closing the connection");
        }
    }
}