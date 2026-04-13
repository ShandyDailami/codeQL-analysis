import java.net.ServerSocket;
import java.net.Socket;

public class java_22455_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here, we're just starting a new thread to handle the communication
                // with the client, but this is not the best way to handle this.
                // A real-world application would probably need to handle multiple clients,
                // use threads for concurrent processing, handle errors, and so on.
                new HandlerThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_22455_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we're just reading the data from the client
            // This is a security-sensitive operation. 
            // It's better to use a secure channel (like SSL) for this.
            socket.getInputStream().read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}