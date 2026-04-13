import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07768_SocketServer_A07 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication here (e.g. using SSL)
                // Assume we are using a hardcoded username and password for simplicity
                String username = "user";
                String password = "password";

                String clientUsername = socket.getInputStream().readUTF();
                String clientPassword = socket.getInputStream().readUTF();

                if (username.equals(clientUsername) && password.equals(clientPassword)) {
                    // Authentication successful, proceed with data transfer
                    handleDataTransfer(socket);
                } else {
                    // Authentication failed, close the connection
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleDataTransfer(Socket socket) {
        // TODO: Implement data transfer logic here
    }
}