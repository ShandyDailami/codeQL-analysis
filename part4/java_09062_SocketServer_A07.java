import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09062_SocketServer_A07 {

    private static final String AUTH_SUCCESS = "Auth Success";
    private static final String AUTH_FAILURE = "Auth Failure";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                new SocketHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind port " + PORT);
            System.exit(-1);
        }
    }

    private static class SocketHandler extends Thread {
        private Socket socket;

        public java_09062_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // authentication logic here
            if (authenticate()) {
                // further processing here
            } else {
                sendResponse(AUTH_FAILURE);
            }
            socket.close();
        }

        private boolean authenticate() {
            // authentication logic here, for example using MD5
            // you can replace the following line with your own authentication logic
            return true;
        }

        private void sendResponse(String response) {
            // sending response to the client
        }
    }
}