import java.net.ServerSocket;
import java.net.Socket;

public class java_01464_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Handle the client connection in a new thread
                new Handler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_01464_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            socket.getInputStream();
            socket.getOutputStream();

            // TODO: Add code to handle the socket connection

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}