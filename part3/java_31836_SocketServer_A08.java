import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31836_SocketServer_A08 {

    // Constants
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = getPort(args);
        try {
            ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                new SocketServerThread(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Server failed to start.");
            e.printStackTrace();
        }
    }

    private static int getPort(String[] args) {
        if (args.length == 0) {
            return DEFAULT_PORT;
        } else {
            return Integer.parseInt(args[0]);
        }
    }

    private static class SocketServerThread extends Thread {

        private Socket socket;

        SocketServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client here.
            // For now, we just echo back the message received.
            try {
                SocketHandler handler = new SocketHandler(socket);
                handler.handle();
            } catch (Exception e) {
                System.out.println("Error handling client on port " + socket.getPort());
                e.printStackTrace();
            }
        }
    }

    private static class SocketHandler {

        private Socket socket;
        private byte[] buffer = new byte[1024];
        private int length;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        void handle() throws Exception {
            while ((length = socket.getInputStream().read(buffer)) != -1) {
                // Echo back the message received
                socket.getOutputStream().write(buffer, 0, length);
            }
        }
    }
}