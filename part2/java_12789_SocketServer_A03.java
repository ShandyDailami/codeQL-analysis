import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_12789_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started!");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected!");
                executor.execute(new ClientHandler(socket));
            } catch (Exception ex) {
                System.out.println("Error handling client connection");
                ex.printStackTrace();
            }
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_12789_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);
                String message = dis.readUTF();

                System.out.println("Received: " + message);

                if (isMaliciousInput(message)) {
                    System.out.println("Detected malicious input, dropping connection");
                    socket.close();
                } else {
                    String response = "Hello, client!";
                    OutputStream output = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(output);
                    dos.writeUTF(response);
                }

            } catch (Exception ex) {
                System.out.println("Error handling client connection");
                ex.printStackTrace();
            }
        }

        private boolean isMaliciousInput(String input) {
            // TODO: Implement your own detection logic for A03_Injection
            // This is a placeholder for now, you may need to use a library like JNDI or JSR 250.
            // This is a simple example where a string containing a script tag is considered a malicious input
            return input.contains("<script>");
        }
    }
}