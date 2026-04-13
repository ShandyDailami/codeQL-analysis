import java.io.*;
import java.net.*;

public class java_03175_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_03175_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                String message;
                if ((message = in.readLine()) != null) {
                    processRequest(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void processRequest(String request) {
            // TODO: Implement authentication logic here, for example using AuthFailureDetector
            // For the sake of the example, we'll assume that the request contains a username
            String username = request.split(":")[1];

            // Assume that the username is a valid one
            boolean isValid = true;

            if (!isValid) {
                // If the username is not valid, send a response
                out.println("HTTP/1.1 401 Unauthorized");
                out.println("WWW-Authenticate: Basic realm=\"AuthServer\"");
                out.println();
                out.flush();
            } else {
                // If the username is valid, proceed with the request
                out.println("HTTP/1.1 200 OK");
                out.println();
                out.flush();
            }
        }
    }
}