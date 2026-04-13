import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_35666_SocketServer_A07 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "password");
    }

    public static void main(String[] args) {
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected");
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                         PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
                        String clientAddress = clientSocket.getInetAddress().getHostAddress();
                        System.out.println("Client address: " + clientAddress);
                        String clientRequest = reader.readLine();
                        System.out.println("Client request: " + clientRequest);
                        String response;
                        if ("exit".equals(clientRequest)) {
                            writer.println("Bye!");
                            break;
                        } else {
                            String username = clientRequest.split(" ")[0];
                            String password = clientRequest.split(" ")[1];
                            if (username != null && password != null) {
                                if (users.containsKey(username) && users.get(username).equals(password)) {
                                    writer.println("Authorized");
                                } else {
                                    writer.println("Unauthorized");
                                }
                            } else {
                                writer.println("Invalid request");
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}