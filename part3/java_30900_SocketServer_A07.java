import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30900_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final String AUTHENTICATED = "Authenticated";
    private static final String FAILED = "Failed";

    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(5);

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is running on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted");

                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_30900_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String username = reader.readLine();
                String password = reader.readLine();

                if (authenticate(username, password)) {
                    writer.println(AUTHENTICATED);
                } else {
                    writer.println(FAILED);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String username, String password) {
            return USERNAME.equals(username) && PASSWORD.equals(password);
        }
    }
}