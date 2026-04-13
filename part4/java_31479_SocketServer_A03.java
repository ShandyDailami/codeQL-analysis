import java.io.*;
import java.net.*;

public class java_31479_SocketServer_A03 {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));

        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Perform operations that are not considered as an injection
            new HandlerThread(socket).start();
        }
    }

    private static class HandlerThread extends Thread {
        private Socket socket;

        public java_31479_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    // You can add more operations here
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}