import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36521_SocketServer_A07 {
    private ExecutorService executor;
    private int port;

    public java_36521_SocketServer_A07(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;

        public java_36521_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Read username and password from client
                String username = in.readLine();
                String password = in.readLine();

                // Authenticate user
                if (authenticate(username, password)) {
                    // Send response to client
                    out.write("Authentication successful\n".getBytes());
                } else {
                    out.write("Authentication failed\n".getBytes());
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String username, String password) {
            // Implement your own authentication logic here.
            // This is a simple example, you should never store passwords in plain text.
            return username.equals("admin") && password.equals("password");
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(1234).start();
    }
}