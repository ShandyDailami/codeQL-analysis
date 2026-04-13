import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class java_05316_SocketServer_A01 {
    private static final int PORT = 8001;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected to: " + socket.getRemoteSocketAddress());
                new EchoHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class EchoHandler extends Thread {
        private Socket socket;

        public java_05316_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = socket.getInputStream().read(buffer);
                    if (bytesRead < 0) {
                        break;
                    }
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}