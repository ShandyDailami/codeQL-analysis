import java.io.*;
import java.net.*;
import java.util.*;

public class java_10982_SocketServer_A07 {

    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static String[] bannedIps = new String[]{"192.168.1.1"};

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        while(true) {
            Socket socket = server.accept();
            handle(socket);
        }
    }

    public static void handle(Socket socket) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String ip = socket.getInetAddress().getHostAddress();
            if(isBanned(ip)) {
                writer(socket.getOutputStream(), "Sorry, your IP address has been banned.");
                return;
            }
            String user = reader.readLine();
            if(!authenticate(user)) {
                writer(socket.getOutputStream(), "Sorry, invalid username or password.");
                return;
            }
            writer(socket.getOutputStream(), "Welcome, " + user + "!");
        }
    }

    public static boolean isBanned(String ip) {
        return Arrays.asList(bannedIps).contains(ip);
    }

    public static boolean authenticate(String user) {
        return validUsers.contains(user);
    }

    public static void writer(OutputStream out, String message) throws IOException {
        out.write((message + "\n").getBytes());
        out.flush();
    }
}