import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20060_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here we use a very basic form of security, but it's not recommended for production use.
                // In a real world application, you would want to use SSL/TLS for encryption and authentication,
                // and handle cases where the client sends data that the server should not understand.
                // The below code is just a placeholder for the purpose of the example.
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_20060_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Code to handle the connection goes here
    }
}