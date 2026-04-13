import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25446_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    private static String getUsernamePassword(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Send username and password
        out.writeUTF("Username: ");
        String username = in.readLine();
        out.writeUTF("Password: ");
        String password = in.readLine();
        out.writeUTF("Confirm: ");
        String confirm = in.readLine();

        if (!username.equals(USERNAME) || !password.equals(PASSWORD) || !confirm.equals(PASSWORD)) {
            throw new IllegalArgumentException("Authentication failed");
        }

        return username + ":" + password;
    }

    public static void main(String[] args) throws IOException, ExecutionException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started at port: 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            final String usernamePassword = getUsernamePassword(socket);

            new ExecutorService(1).execute(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    // Receive message from client
                    out.writeUTF("Server: Hello " + usernamePassword);
                    String message = in.readLine();
                    System.out.println("Received message: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}