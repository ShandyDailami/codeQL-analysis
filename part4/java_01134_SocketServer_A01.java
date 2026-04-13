import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01134_SocketServer_A01 {
    private static final String AUTHENTICATE = "Basic " + javax.xml.crypto.data.Data.base64(("username" + ":" + "password").getBytes());
    private static final String AUTH_FAILURE = "HTTP/1.1 401 Unauthorized\r\n" +
            "Content-Type: text/html; charset=utf-8\r\n" +
            "Connection: close\r\n\r\n" +
            "Access is denied for this request.";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for connection on port " + 8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());
            String request = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                request += line;
            }

            if (authenticate(request)) {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/html; charset=utf-8");
                writer.println();
                writer.println("<h1>Hello, World!</h1>");
                writer.flush();
            } else {
                writer(AUTH_FAILURE, socket);
            }

            socket.close();
        }
    }

    private static boolean authenticate(String request) {
        return request.contains(AUTHENTICATE);
    }

    private static void writer(String message, Socket socket) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(message);
        writer.flush();
    }
}