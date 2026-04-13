import java.io.*;
import java.net.*;

public class java_27444_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final String INCORRECT_CREDENTIALS = "Incorrect credentials!";

    public static void main(String[] args) {
        System.out.println("Starting secure server on port " + PORT + "...");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());
                new EchoHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Failed to accept connections: " + ex);
            System.exit(-1);
        }
    }

    private static class EchoHandler extends Thread {
        private final Socket socket;

        public java_27444_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket.getInputStream();
                 socket.getOutputStream()) {

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("password")) {
                        out.writeUTF(INCORRECT_CREDENTIALS);
                        out.flush();
                        continue;
                    }
                    out.writeUTF(message);
                    out.flush();
                }
            } catch (IOException ex) {
                System.out.println("Error handling client " + socket.getRemoteSocketAddress() + ": " + ex);
            }
        }
    }
}