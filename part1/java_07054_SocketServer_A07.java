import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_07054_SocketServer_A07 {
    private static final String SECRET = "secret"; // shared secret
    private static Map<String, String> users = new HashMap<>(); // dummy users storage

    static class Handler extends Thread {
        private Socket socket;

        public java_07054_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // read request
                String request = new String(socket.getInputStream().readNBytes(1024));
                // check authentication
                if (request.equals("A07_AuthFailure")) {
                    String response = "Success"; // or "Failure"
                    socket.getOutputStream().write(response.getBytes());
                } else {
                    socket.getOutputStream().write("Invalid Request".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // server socket
        while (true) {
            Socket socket = serverSocket.accept(); // accept connection
            Handler handler = new Handler(socket); // create handler
            handler.start(); // start handler
        }
    }
}