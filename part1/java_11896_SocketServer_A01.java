import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11896_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                // handle client connection in a separate thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_11896_SocketServer_A01(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // read from client and write to client
            // here we're just echoing back the data
            while ((clientSocket.getInputStream().read()) != -1) {
                clientSocket.getOutputStream().write(clientSocket.getInputStream().read());
                clientSocket.getOutputStream().flush();
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}