import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32069_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Assuming port number
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = serverSocket.accept(); // Blocking call, waiting for client
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_32069_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from the socket and process the request
            // Here, we're just printing the received data, but in a real application
            // you'd probably want to parse the request and perform an appropriate action
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    break; // Connection closed by client
                }
                String request = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}