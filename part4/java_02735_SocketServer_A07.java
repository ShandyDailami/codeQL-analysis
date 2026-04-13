import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02735_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_02735_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle client communication here
        // e.g. read data from client, send response, etc.
    }
}