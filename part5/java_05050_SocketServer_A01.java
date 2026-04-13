import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05050_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle client connection here
                // For simplicity, we're just printing the message
                // to the console.
                // In a real-world application, you'd probably want to send
                // a response back to the client.
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_05050_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client's request here
        // For simplicity, we're just printing the message
        // to the console.
        // In a real-world application, you'd probably want to send
        // a response back to the client.
        try {
            socket.getInputStream();
            System.out.println("Client's message: " + socket.getInputStream().read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}