import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00125_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create a new thread to handle the client request
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_00125_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can handle the client request and send a response
            // For simplicity, we'll just echo the received data back to the client
            try {
                while ((socket.getInputStream().read()) != -1) {
                    socket.getOutputStream().write(socket.getInputStream().read());
                }
                socket.getOutputStream().close();
                socket.getInputStream().close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}