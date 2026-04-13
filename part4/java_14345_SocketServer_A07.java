import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14345_SocketServer_A07 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        serverSocket = new ServerSocket(5000);
        System.out.println("Server started at port 5000");

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_14345_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Here we perform the security-sensitive operation of authentication failure
                // This is an example and might not be suitable for real-world use
                if (authenticateUser(clientSocket)) {
                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                    String message;
                    while ((message = in.readUTF()) != null) {
                        System.out.println("Received: " + message);
                        out.writeUTF("Message received");
                    }
                } else {
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                    out.writeUTF("Authentication failure");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticateUser(Socket clientSocket) {
            // Implement authentication logic here
            // This is a placeholder and may not be suitable for real-world use
            return true;
        }
    }
}