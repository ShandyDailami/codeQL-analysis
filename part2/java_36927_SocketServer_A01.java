import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36927_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT + ".");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the communication
                new HandleConnection(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class HandleConnection extends Thread {
    private Socket socket;

    public java_36927_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the client's message
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // Convert the message to a string
            String message = new String(buffer);
            System.out.println("Client says: " + message);

            // Reply with a message
            String response = "Hello, client!";
            byte[] responseBuffer = response.getBytes();
            socket.getOutputStream().write(responseBuffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}