import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01756_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Server could not listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;

        public java_01756_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Code to handle the client connection and secure communication
            // with the client goes here.
        }
    }
}