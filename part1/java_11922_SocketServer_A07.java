import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11922_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");

            // Handle the client
            new HandleClientThread(socket).start();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_11922_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection
        // ...
    }
}