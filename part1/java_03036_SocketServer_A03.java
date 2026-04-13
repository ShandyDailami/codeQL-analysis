import java.net.ServerSocket;
import java.net.Socket;

public class java_03036_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected!");

                // Start a new thread to handle communication with the client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_03036_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle communication with the client here
            // For now, just print out the received data
            try {
                while ((socket.getInputStream().read()) != -1) {
                    System.out.println(socket.getInputStream().read());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}