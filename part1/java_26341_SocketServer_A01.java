import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26341_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to port 5000
        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server is listening on port 5000");

        // Accept a new connection
        while (true) {
            Socket socket = serverSocket.accept();

            // Create a new thread for each connection
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_26341_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            socket.getInputStream();
            socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}