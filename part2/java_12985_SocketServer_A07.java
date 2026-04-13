import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12985_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new EchoThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EchoThread extends Thread {
    private Socket socket;

    public java_12985_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while ((socket.getInputStream().read() != -1)) {
                socket.getOutputStream().write(socket.getInputStream().read());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}