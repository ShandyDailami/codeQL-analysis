import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08080_SocketServer_A03 {
    private static final int PORT = 12345; // define the port number

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_08080_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the client's message
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);

            // Echo the message back to the client
            socket.getOutputStream().write(message.getBytes());
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}