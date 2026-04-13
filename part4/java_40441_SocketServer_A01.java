import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40441_SocketServer_A01 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            while (true) {
                System.out.println("Waiting for connection...");
                Socket socket = server.accept();
                System.out.println("Connected!");

                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_40441_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection
        // Close the connection immediately upon completion
        try {
            while ((socket.getInputStream().read() != -1)) ;
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}