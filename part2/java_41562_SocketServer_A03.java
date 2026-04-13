import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41562_SocketServer_A03 {
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            // Handle the connection in a new thread
            new HandlerThread(socket).start();
        }
    }
}

class HandlerThread extends Thread {
    private final Socket socket;

    public java_41562_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle incoming data here
    }
}