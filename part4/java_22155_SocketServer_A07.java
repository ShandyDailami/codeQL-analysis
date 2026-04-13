import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_22155_SocketServer_A07 {

    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                try (Socket clientSocket = server.accept()) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                        String clientMessage = in.readLine();
                        System.out.println("Received: " + clientMessage);
                        String usernameAndPassword = clientMessage.split(" ")[0];
                        String password = clientMessage.split(" ")[1];
                        String storedPassword = userDatabase.get(usernameAndPassword);
                        if (storedPassword != null && storedPassword.equals(password)) {
                            out.println("A07_AuthSuccess");
                        } else {
                            out.println("A07_AuthFailure");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}