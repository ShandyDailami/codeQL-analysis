import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_17097_SocketServer_A07 {
    private static final String DEFAULT_PASSWORD = "password";
    private HashMap<String, String> loginMap = new HashMap<>();
    private ServerSocket serverSocket;

    public java_17097_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        loginMap.put("user", "password");
    }

    public void startServer() {
        System.out.println("Server started. Waiting for connections...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected");
                handleClient(clientSocket);
            } catch (IOException e) {
                System.out.println("Error handling client");
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                if (authenticateClient(clientSocket, clientMessage)) {
                    out.println("Access granted");
                    out.flush();
                } else {
                    out.println("Access denied");
                    out.flush();
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error handling client");
            e.printStackTrace();
        }
    }

    private boolean authenticateClient(Socket clientSocket, String passwordAttempt) {
        return passwordAttempt.equals(loginMap.get(clientSocket.getRemoteSocketAddress().toString()));
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(12345);
        server.startServer();
    }
}