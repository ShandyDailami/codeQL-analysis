import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22562_SocketServer_A07 {

    private static ExecutorService executor;
    private static final String USER_FILE = "users.txt";

    public static void main(String[] args) throws Exception {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected");
            executor.execute(new ClientHandler(client));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket client;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_22562_SocketServer_A07(Socket client) {
            this.client = client;
            try {
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                writer = new PrintWriter(client.getOutputStream(), true);
            } catch (Exception e) {
                close();
            }
        }

        @Override
        public void run() {
            String request, response;
            while ((request = reader.readLine()) != null) {
                if (request.equals("exit")) {
                    close();
                    break;
                }

                String[] credentials = request.split(" ");
                if (authenticate(credentials[0], credentials[1])) {
                    response = "Authentication successful!";
                } else {
                    response = "Authentication failed!";
                }

                writer.println(response);
                writer.flush();
            }
        }

        private void close() {
            executor.execute(() -> {
                try {
                    client.close();
                    System.out.println("Client disconnected");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        private boolean authenticate(String username, String password) {
            try (BufferedReader in = new BufferedReader(new FileReader(USER_FILE))) {
                String fileLine;
                while ((fileLine = in.readLine()) != null) {
                    String[] userCredentials = fileLine.split(" ");
                    if (userCredentials[0].equals(username) && userCredentials[1].equals(password)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }
}