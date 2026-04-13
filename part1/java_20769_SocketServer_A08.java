import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20769_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Handle the client connection in a new thread
                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;

        public java_20769_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can handle the client connection using standard Java Socket libraries
                // For example, reading from and writing to the client, using InputStream and OutputStream
                // ...
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}