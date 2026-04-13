import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36503_SocketServer_A03 {

    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            // Create server socket
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            // Wait for client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Send response
            OutputStream outputStream = clientSocket.getOutputStream();
            String response = "Hello, client!";
            outputStream.write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}