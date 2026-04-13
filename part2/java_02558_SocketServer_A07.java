import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02558_SocketServer_A07 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        // Creating a new ServerSocket to listen on port 9876
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Accept a new client connection
            Socket socket = serverSocket.accept();

            // Handle the connection with a new thread
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_02558_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
    }
}