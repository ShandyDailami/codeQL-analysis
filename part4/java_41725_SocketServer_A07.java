import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_41725_SocketServer_A07 {
    private static final String USER = "test";
    private static final String PASSWORD = "test";
    private static final String AUTHENTICATED_USER = "test:test";

    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                try (Socket socket = server.accept()) {
                    try (InputStream input = socket.getInputStream();
                         BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                        String request = reader.readLine();
                        if (request.isEmpty()) {
                            continue;
                        }
                        String[] parts = request.split(" ");
                        if (parts.length != 3 || !parts[0].equals("GET")) {
                            send401(socket.getOutputStream());
                            continue;
                        }
                        String[] credentials = parts[1].split(":");
                        if (credentials.length != 2 || !PASSWORD(credentials[0]).equals(credentials[1])) {
                            send401(socket.getOutputStream());
                            continue;
                        }
                        send200(socket.getOutputStream());
                    }
                }
            }
        }
    }

    private static void send401(PrintWriter output) throws Exception {
        output.println("HTTP/1.1 401 Unauthorized");
        output.println("WWW-Authenticate: Basic realm=\"Auth Required\"");
        output.println();
    }

    private static void send200(PrintWriter output) throws Exception {
        output.println("HTTP/1.1 200 OK");
        output.println();
    }

    private static String PASSWORD(String password) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return Base64.getEncoder().encodeToString(digest.digest(password.getBytes()));
    }
}