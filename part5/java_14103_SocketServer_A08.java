import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14103_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Thread to handle the communication with the client
                HandleClientThread thread = new HandleClientThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Class to handle communication with the client
    private static class HandleClientThread extends Thread {
        private Socket socket;

        public java_14103_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Add your code here to handle the communication with the client
            // For example, read data from the client, send data back to the client, etc.
        }
    }
}