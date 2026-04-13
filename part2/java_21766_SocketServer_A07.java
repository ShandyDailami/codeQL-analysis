import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_21766_SocketServer_A07 {

    private static final String AUTH_FILE = "auth";
    private static final String USER_FILE = "users";
    private static final Pattern pattern = Pattern.compile("^[A-Za-z0-9_]{3,16}$");
    private static final String MD5 = "MD5";

    private static String digest(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            byte[] hash = md.digest(input.getBytes());
            return String.format("%032x", hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean authenticate(String user, String pass) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(AUTH_FILE));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                String[] parts = line.split(":");
                if (user.equals(parts[0]) && digest(pass).equals(parts[1])) {
                    return true;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189, 10000);

        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String user = in.readLine();
            if (user == null || !pattern.matcher(user).matches() || !authenticate(user, in.readLine())) {
                out.println("Auth failed");
                out.close();
                socket.close();
                continue;
            }

            out.println("Auth successful");
            out.close();
        }
    }
}