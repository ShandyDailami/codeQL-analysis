import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19328_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handle client connection in a separate thread
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_19328_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive data from client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead == -1) {
                socket.close();
                System.out.println("Client disconnected");
            } else {
                // Process the received data
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Send response back to client
                String response = "Server received: " + message;
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}