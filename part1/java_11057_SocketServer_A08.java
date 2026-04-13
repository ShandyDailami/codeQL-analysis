import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11057_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Handling the socket in a new thread
            Handler handler = new Handler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}

class Handler implements Runnable {

    private Socket socket;

    public java_11057_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Reading the request from the client
        // ...

        // Handling the request and sending the response
        // ...
    }
}