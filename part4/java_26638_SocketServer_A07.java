import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26638_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket and wait for a client to connect
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started at port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        Socket socket;

        public java_26638_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Receive data from client and send it back
                while ((socket.getInputStream().read()) != -1) {
                    socket.getOutputStream().write("OK".getBytes());
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}