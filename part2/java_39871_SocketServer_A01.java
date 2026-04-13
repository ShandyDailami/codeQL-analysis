import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39871_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for handling the client
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind port " + PORT);
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_39871_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Here you can add code to securely handle the client, e.g.,
            // verify the client's identity, check for any potential security threats, etc.
            // In this example, we're just echoing back everything the client sends.
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    break;
                }

                socket.getOutputStream().write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}