import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35266_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("New client connected");

                    AuthHandler handler = new AuthHandler(client);
                    handler.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class AuthHandler extends Thread {
    private Socket client;

    public java_35266_SocketServer_A07(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            String username = reader.readLine();
            String password = reader.readLine();

            if (!authenticate(username, password)) {
                writer.println("Authentication failed");
                return;
            }

            writer.println("Authentication successful");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}