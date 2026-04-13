import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14234_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // handle client connection in a new thread
                new Thread(new SocketHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_14234_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // here you can add your business logic related to the socket connection
            // for example, you can read data from the client and send it back
            // you can perform security-sensitive operations such as SSL/TLS for encryption

            // here is a simple example of reading data from the client
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            String message = new String(bytes);
            System.out.println("Received: " + message);

            // here is a simple example of sending data back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}