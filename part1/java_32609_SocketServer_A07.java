import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_32609_SocketServer_A07 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("New connection accepted: " + sslSocket.getRemoteSocketAddress());

                executor.execute(new Handler(sslSocket));
            } catch (IOException e) {
                System.out.println("Failed to accept connection: " + e.getMessage());
            }
        }
    }

    private static class Handler implements Runnable {
        private final SSLSocket socket;

        Handler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // Read the username
                String username = dis.readUTF();
                System.out.println("Username: " + username);

                // Read the password
                String password = dis.readUTF();
                System.out.println("Password: " + password);

                // For the sake of simplicity, we'll just check if the username and password
                // are correct. In a real application, you would need to use a secure way
                // to compare the passwords, such as a hashing algorithm.
                if ("test".equals(username) && "password".equals(password)) {
                    dos.writeUTF("Success");
                    System.out.println("Authentication successful!");
                } else {
                    dos.writeUTF("Failure");
                    System.out.println("Authentication failed!");
                }

                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to handle connection: " + e.getMessage());
            }
        }
    }
}