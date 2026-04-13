import java.io.*;
import java.net.*;
import java.util.*;

public class java_35674_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final String CRLF = "\r\n";

    private static boolean checkPassword(String password) {
        return "password".equals(password);
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket socket = server.accept();
            new SecureSocketServerHandler(socket).start();
        }
    }

    private static class SecureSocketServerHandler extends Thread {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        SecureSocketServerHandler(Socket socket) {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        public void run() {
            String request, response;
            try {
                request = in.readLine();
                if (request == null)
                    return;
                if (!checkPassword(request)) {
                    response = "HTTP/1.1 401 Unauthorized\r\n" +
                            "WWW-Authenticate: Basic realm=\"Secure Area\"\r\n" +
                            CRLF;
                    out.println(response);
                    out.flush();
                    return;
                }
                response = "HTTP/1.1 200 OK\r\n" +
                        CRLF;
                out.println(response);
                out.flush();

                String line;
                while ((line = in.readLine()) != null) {
                    out.println(line);
                    out.flush();
                }
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}