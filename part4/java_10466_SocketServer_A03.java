import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10466_SocketServer_A03 {
    private static final int PORT = 9876;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            System.out.println("Error while starting the server.");
            e.printStackTrace();
            stopServer();
        }
    }

    public static void handleClient(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream writer = socket.getOutputStream();

            String clientMsg;
            while ((clientMsg = reader.readLine()) != null) {
                // Perform security-sensitive operations here.
                // For example, removing user input to prevent SQL injection:
                // clientMsg = clientMsg.replace(";", "");

                System.out.println("Received: " + clientMsg);
                writer.write("Server received: " + clientMsg + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Error while handling client.");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error while closing socket.");
                e.printStackTrace();
            }
        }
    }

    public static void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error while closing server socket.");
            e.printStackTrace();
        }
    }
}