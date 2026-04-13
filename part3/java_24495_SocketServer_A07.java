import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24495_SocketServer_A07 {

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Simulating authentication failure by setting the socket to non-blocking
                clientSocket.setSoTimeout(1000);

                // Simulating an authentication failure by attempting to read from the socket
                try {
                    clientSocket.getInputStream().read();
                } catch (IOException e) {
                    System.out.println("Authentication failure occurred. Closing connection.");
                    clientSocket.close();
                }

                // Continue processing the request
                // ...

            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}