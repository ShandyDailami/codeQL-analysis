import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13780_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected!");

                // Start a new thread to handle the client request
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_13780_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client request here
        // For simplicity, this example just echoes back the request
        try {
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write(socket.getInputStream().read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}