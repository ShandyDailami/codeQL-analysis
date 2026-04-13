import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19670_SocketServer_A08 {

    private static final int PORT = 4445; // Change this value to your desired port

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                new Thread(new ClientHandler(socket)).start();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_19670_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // TODO: Implement your client-side security here, e.g., use SSL or other cryptographic methods
            // For simplicity, we'll just accept all connections
            socket.setTCPNoDelay(true);
            socket.setReceiveBufferSize(1024);
            socket.setSendBufferSize(1024);
            socket.setSoLinger(true, 0);

            // TODO: Handle the client's data here
            // For simplicity, we'll just echo back the data received
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                socket.getOutputStream().write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}