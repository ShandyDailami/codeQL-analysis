import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22670_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start");
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private Socket socket;
        private String username;
        private String password;

        public java_22670_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.username = "anonymous";
            this.password = "password";
        }

        @Override
        public void run() {
            try (Socket client = socket) {
                this.username = client.getRemoteSocketAddress().toString();
                this.password = new String(client.getInputStream().readNBytes(client.getInputStream().available()));

                if (!authenticate()) {
                    System.out.println("Authentication failed for " + this.username);
                    client.close();
                    return;
                }

                System.out.println("Authentication successful for " + this.username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate() {
            return USERNAME.equals(this.username) && PASSWORD.equals(this.password);
        }
    }
}