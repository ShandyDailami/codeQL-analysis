import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class java_29459_SocketServer_A08 {

    // Server socket.
    private ServerSocket serverSocket;

    public java_29459_SocketServer_A08(int port) {
        try {
            serverSocket = new ServerSocket(port, 0, InetAddress.getByName("localhost"));
        } catch (Exception e) {
            System.out.println("Failed to bind port: " + port);
            System.exit(-1);
        }
        System.out.println("Server started on port: " + port);
    }

    public void listenForConnections() {
        while (true) {
            try {
                // Blocking call to accept a new connection.
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Stream handling for the connection.
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                if (bytesRead < 0) {
                    System.out.println("Client disconnected.");
                    socket.close();
                } else {
                    // Process the input from the client.
                    // In this example, we simply echo back the input.
                    outputStream.write(buffer, 0, bytesRead);
                }

                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(8080).listenForConnections();
    }
}