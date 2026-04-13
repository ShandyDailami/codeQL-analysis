import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37581_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Here you would typically create a thread for each connected client
                // but for simplicity, this example will just echo back the received data
                new EchoHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to start: " + e.getMessage());
        }
    }
}

class EchoHandler extends Thread {
    private final Socket socket;

    public java_37581_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (socket.getInputStream(); socket.getOutputStream()) {
            int data;
            while ((data = socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write(data);
            }
        } catch (IOException e) {
            System.err.println("Exception occurred while reading from or writing to socket");
        }
    }
}