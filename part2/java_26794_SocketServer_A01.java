import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26794_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                new EchoThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            System.exit(-1);
        }
    }

    private static class EchoThread extends Thread {
        private Socket socket;

        public java_26794_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket = new Socket();
                 socket.getInputStream();
                 socket.getOutputStream()) {

                byte[] bytes = new byte[1024];
                int bytesRead;

                while ((bytesRead = socket.getInputStream().read(bytes)) != -1) {
                    socket.getOutputStream().write(bytes, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}