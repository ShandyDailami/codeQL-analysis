import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20067_SocketServer_A01 {

    private static final String SERVER_MESSAGE = "Hello, client!";
    private static final int PORT = 8888;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        new SendMessageThread(socket).start();
    }

    private static class SendMessageThread extends Thread {
        private final Socket socket;

        public java_20067_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket.getOutputStream()
                      .asOutputStream()
                      .wrapConnection()
                      .setWriteBufferSize(4096)
            ) {
                System.out.println("Writing message to client: " + SERVER_MESSAGE);
                socket.getOutputStream().write(SERVER_MESSAGE.getBytes());
                socket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}