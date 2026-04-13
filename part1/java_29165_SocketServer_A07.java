import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class java_29165_SocketServer_A07 {
    private static final String HOST = "localhost";
    private static final int PORT = 1234;
    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(output, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String user = reader.readLine();
            String pass = reader.readLine();

            String expectedPass = credentials.get(user);

            if (expectedPass == null || !expectedPass.equals(pass)) {
                writer.println("Invalid username or password");
                writer.close();
                socket.close();
            } else {
                writer.println("Welcome " + user);
                writer.close();
            }
        }
    }
}