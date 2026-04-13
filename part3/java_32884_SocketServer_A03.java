import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32884_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 12345;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // Accept client socket
            socket = serverSocket.accept();
            System.out.println("Client has connected");

            // Handle communication with client
            // This is a placeholder for a more complex server
            byte[] bytes = new byte[1000];
            socket.getInputStream().read(bytes);
            String request = new String(bytes);
            System.out.println("Received: " + request);

            byte[] msg = "Hello, client!".getBytes();
            socket.getOutputStream().write(msg);
            System.out.println("Sent: " + new String(msg));

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}