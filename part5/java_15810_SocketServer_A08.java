import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15810_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                new A08_IntegrityFailureSocketServerThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            System.out.println("Server is stopped.");
        }
    }
}

class A08_IntegrityFailureSocketServerThread extends Thread {
    private Socket socket;

    public java_15810_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Read from the socket
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) break;

                // Here you can add code to check the integrity of the data
                // For example, you can compare the data with a hash of the previous data

                // You can also use a cryptographic algorithm to check the integrity of the data
                // For example, you can hash the data and compare it with a hash of the previous data

                // For simplicity, we will just print out the data
                System.out.println("Received: " + new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}