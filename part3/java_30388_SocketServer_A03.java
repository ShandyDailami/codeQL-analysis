import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30388_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Handle the client connection
                new HandleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;

        public java_30388_SocketServer_A03(Socket socket) {
            this.socket = socket;
            start();
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }
}