import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26120_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 1234;

        // Create a server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port, 100, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server is listening on port " + port);

        while (true) {
            try {
                // Wait for a client to connect
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Handle the client in a new thread
                new Thread(new SocketHandler(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_26120_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection
        // Here you can add the logic related to A01_BrokenAccessControl
        // For example, you can handle the request and response here
    }
}