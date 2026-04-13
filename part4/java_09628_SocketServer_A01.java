import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09628_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for connections");
       
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_09628_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Implement secure communication protocol here
            // For now, we will simulate a secure communication by echoing back the client's messages
            try {
                while ((socket.getInputStream().read()) != -1) {
                    socket.getOutputStream().write(socket.getInputStream().read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }
    }
}