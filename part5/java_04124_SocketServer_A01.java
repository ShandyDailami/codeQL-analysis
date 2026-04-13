import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04124_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_04124_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add your security-sensitive operations related to A01_BrokenAccessControl
            // For example, checking for a valid username and password, or encrypting the client's data

            // Reading from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = reader.readLine();
            System.out.println("Received: " + clientMessage);

            // Sending a response back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}