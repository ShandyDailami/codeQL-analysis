import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01885_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        // Step 1: Create a ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Step 2: Accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected");

                // Step 3: Handle the communication with the client
                new Thread(new SocketHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_01885_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Step 4: Set up input and output streams
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                // Step 5: Handle the received data
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Step 6: Send a response
                String response = "Server: " + message;
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}