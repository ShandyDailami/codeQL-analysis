import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13388_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client in a new thread
                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HandleClient extends Thread {
        Socket socket;

        HandleClient(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // TODO: Implement the client-side handling logic
        }
    }
}