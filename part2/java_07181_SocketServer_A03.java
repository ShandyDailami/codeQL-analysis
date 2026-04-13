import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07181_SocketServer_A03 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for client connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations here
                // For example, start a new thread to handle the communication with the client
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClientThread extends Thread {
        private Socket socket;

        public java_07181_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // For example, read data from the client and send a response
            // You can use a standard library like BufferedReader and PrintWriter
            // to read and write data to the socket
        }
    }
}