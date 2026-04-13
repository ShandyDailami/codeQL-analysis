import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21536_SocketServer_A07 {

    private static final String LOCAL_HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here, we're only accepting connections from a specific IP address
                // In a real application, you'd want to verify this
                if (!socket.getInetAddress().getHostAddress().equals(LOCAL_HOST)) {
                    System.out.println("Connection from " + socket.getInetAddress() + " is not allowed");
                    socket.close();
                    continue;
                }

                // Handle the socket connection in a new thread
                new HandleConnection(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleConnection extends Thread {
    private Socket socket;

    public java_21536_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the socket connection here
        // This is just a placeholder, you'd replace this with your actual code
        try {
            // ...
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}