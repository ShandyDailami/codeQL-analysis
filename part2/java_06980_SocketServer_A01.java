import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06980_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234, 0, InetAddress.getByName("localhost"));
        while (true) {
            Socket socket = serverSocket.accept();
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_06980_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // TODO: Handle client
        }
    }
}