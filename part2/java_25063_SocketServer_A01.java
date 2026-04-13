import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25063_SocketServer_A01 {
    private static final String PASSWORD = "securepassword";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Basic access control: password-based authentication
            String clientPassword = clientSocket.getInputStream().readUTF();
            if (!PASSWORD.equals(clientPassword)) {
                System.out.println("Client password did not match");
                clientSocket.close();
                continue;
            }

            // Create a new thread for the client
            new SocketHandler(clientSocket).start();
        }
    }
}

class SocketHandler extends Thread {
    private final Socket socket;

    public java_25063_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle the client connection here
            // ...

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}