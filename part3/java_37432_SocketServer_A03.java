import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_37432_SocketServer_A03 {
    private static final int PORT = 12345;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT, 100, InetAddress.getByName(HOST));
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from: " + socket.getRemoteSocketAddress());
                executorService.execute(new SocketHandler(socket));
            }
        } catch (Exception e) {
            serverSocket.close();
            executorService.shutdown();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_37432_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // TODO: Handle communication with client
            // For now, we're just closing the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}