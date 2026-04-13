import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02160_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started on port 8000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Start a new thread for handling the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_02160_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            socket.getInputStream();
            socket.getOutputStream();

            // Handle the request here
            // For simplicity, we will just echo back the message
            socket.getInputStream().read();
            socket.getOutputStream().write(socket.getInputStream().read());

            // Close the socket connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}