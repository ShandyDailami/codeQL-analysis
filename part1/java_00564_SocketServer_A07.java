import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00564_SocketServer_A07 {
    private int port;

    public java_00564_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;

        public java_00564_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // TODO: Implement authentication
            // For now, we just close the connection after authentication
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(5000).start();
    }
}