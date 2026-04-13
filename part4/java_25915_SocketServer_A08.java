import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25915_SocketServer_A08 {

    private static final String INSECURE_RESPONSE = "This is an insecure response";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            new Handler(socket).start();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;

        public java_25915_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.getInputStream().read(); // read first byte to check if connection is secure

                // send insecure response
                socket.getOutputStream().write(INSECURE_RESPONSE.getBytes());
                socket.getOutputStream().flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}