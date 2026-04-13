import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40521_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Create a new thread for each connection
            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }
}

class ServerThread implements Runnable {
    private Socket socket;

    public java_40521_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Here you can handle the communication with the client
            // For example, you can read and write data to and from the socket
            // However, since we are not using any security-sensitive operations related to injection, we do not include them in this example
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}