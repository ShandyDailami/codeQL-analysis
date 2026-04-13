import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06843_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handle the client connection in a separate thread
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_06843_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive the request from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String request = new String(buffer);

            // Send the response back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}