import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28880_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Handle the client connection in a separate thread
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public java_28880_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client request and response here
            // For simplicity, we just echo back the message
            try {
                socket.getInputStream();
                socket.getOutputStream();
                socket.getInputStream().read();
                socket.getOutputStream().write(socket.getInputStream().read());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}