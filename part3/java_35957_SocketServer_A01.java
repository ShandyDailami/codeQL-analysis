import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35957_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 8080; // standard port

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                new EchoHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to bind port " + port + ": " + e);
            System.exit(-1);
        }
    }

    private static class EchoHandler extends Thread {
        private Socket socket;

        EchoHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    socket.getInputStream().read(buffer);
                    String message = new String(buffer, "UTF-8");
                    System.out.println("Received: " + message);

                    byte[] response = message.getBytes("UTF-8");
                    socket.getOutputStream().write(response);
                    socket.getOutputStream().flush();
                }
            } catch (IOException e) {
                System.err.println("Error in communication with client: " + e);
            }
        }
    }
}