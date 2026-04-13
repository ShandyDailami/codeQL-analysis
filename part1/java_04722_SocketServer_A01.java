import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04722_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Start a new thread to handle the client request
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_04722_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read a request from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();

            // Process the request (e.g., log it)
            System.out.println("Received: " + request);

            // Send a response back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Server: Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}