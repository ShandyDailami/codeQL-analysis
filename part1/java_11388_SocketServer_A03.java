import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11388_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            new ClientHandler(socket).start();
       
            // simulate long running task for security purposes
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            socket.close();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_11388_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle client here
        // ...

        // close connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}