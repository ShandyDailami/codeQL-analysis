import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23390_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to accept connection on port " + PORT);
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_23390_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add the logic to handle the connection, but since we're not dealing with a full-fledged server,
            // let's just print a message and close the connection.
            System.out.println("Handling connection from " + socket.getRemoteSocketAddress());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}