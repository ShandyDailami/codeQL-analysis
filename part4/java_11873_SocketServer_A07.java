import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11873_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is running and waiting for client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Start reading data from client
            new Thread(new SocketDataHandler(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketDataHandler implements Runnable {
    private Socket socket;

    public java_11873_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read data from client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String data = new String(buffer, 0, bytesRead);

            System.out.println("Received: " + data);

            // Send response back to client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}