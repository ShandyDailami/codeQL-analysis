import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_29559_SocketServer_A03 {
    private static final String AUTH_USER = "admin";
    private static final String AUTH_PASS = "password";

    public static void main(String[] args) throws IOException {
        Map<String, String> users = new HashMap<>();
        users.put("admin", "password");

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html;charset=utf-8");
            out.println("Connection: Close");
            out.println();

            String query = socket.getInputStream();
            String username = query.substring(query.indexOf(" ") + 1, query.indexOf(" ") + 3);
            String password = query.substring(query.indexOf(" ") + 4);

            if (users.get(username).equals(password)) {
                out.println("<h1>Welcome, " + username + "</h1>");
            } else {
                out.println("<h1>Access denied</h1>");
            }
            out.close();
        }
    }
}