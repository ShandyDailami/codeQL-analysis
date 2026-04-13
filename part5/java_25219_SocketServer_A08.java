import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25219_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client is connected: " + socket.getInetAddress().getHostAddress());

                // Create a new thread to handle communication with the client
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            System.exit(-1);
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_25219_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, "UTF-8");
            System.out.println("Received: " + message);

            // Send a response
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes("UTF-8"));
            System.out.println("Sent: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}