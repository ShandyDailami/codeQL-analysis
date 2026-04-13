import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class java_21417_SocketServer_A08 {

    public static void main(String[] args) {

        // Create a new server socket with the specified port.
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is running and waiting for client connections...");

            // Infinite loop to accept multiple client connections.
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create a new thread for the client socket.
                new Thread(new SocketHandler(socket)).start();
            }

        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure the server socket is closed.
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_21417_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the socket here, for example, reading from and writing to the socket.
        // This is a very basic example, you should handle the socket in a more secure and efficient way.
        try {
            // Read from the socket.
            byte[] bytes = new byte[1000];
            int length = socket.getInputStream().read(bytes);
            if (length < 0) {
                System.out.println("Client disconnected!");
                return;
            }

            byte[] bytesToSend = "Successfully connected.".getBytes();
            socket.getOutputStream().write(bytesToSend);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}