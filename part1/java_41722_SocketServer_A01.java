import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41722_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080, 0, InetAddress.getByName("localhost"));
        while (true) {
            Socket socket = serverSocket.accept();
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private OutputStream out;

        public java_41722_SocketServer_A01(Socket socket) throws IOException {
            this.socket = socket;
            out = socket.getOutputStream();
        }

        @Override
        public void run() {
            try {
                // Send a message to the client
                out.write("Hello, client!\n".getBytes());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}