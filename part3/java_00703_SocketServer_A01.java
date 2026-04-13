import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00703_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Server port
            System.out.println("Server is listening on port 12345...");

            while (true) { // infinite loop to accept new connections
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");

                // Here, you can create a new thread for each client connection
                // or use an executor to manage the connections in a pool
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_00703_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, you can handle the socket connections. For example, you can read the
        // data from the client, process it, and send a response back to the client.
        // This is a very basic example and real-world applications may need to handle
        // more complex tasks.
    }
}