import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35047_SocketServer_A07 {
    private final ExecutorService execService = Executors.newFixedThreadPool(10);
    private final ServerSocket serverSocket = new ServerSocket(8080);

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                execService.execute(new SocketHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String request = reader.readLine();
                String username = request.split(" ")[1];
                String password = request.split(" ")[2];

                if (validateUser(username, password)) {
                    writer.println("Login successful");
                } else {
                    writer.println("Login failed");
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean validateUser(String username, String password) {
            // Here we're just checking if the username and password match,
            // in a real application, you'd want to actually check the actual database.
            return username.equals("admin") && password.equals("password");
        }
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }
}