import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35561_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_35561_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle the client's request here
        // ...

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}