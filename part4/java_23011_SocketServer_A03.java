import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23011_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // Handle the connection in a new thread
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_23011_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle the socket connection here...
        // In a real-world scenario, this would involve reading from and writing to the socket
        // For the sake of simplicity, this example only prints received messages to the console

        try {
            while ((socket.getInputStream().read()) != -1) {
                System.out.println("Received: " + socket.getInputStream().readUTF());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}