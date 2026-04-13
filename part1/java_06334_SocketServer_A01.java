import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06334_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_06334_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle the client connection here
        // you can use socket to read and write data
    }
}