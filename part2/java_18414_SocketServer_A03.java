import java.net.*;
import java.io.*;
import java.security.*;

public class java_18414_SocketServer_A03 {
    private static final int PORT = 4445;
    private static MessageDigest md;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        md = MessageDigest.getInstance("SHA-256");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Process the incoming client connection
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        public java_18414_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);
                OutputStream output = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);

                // Read the client's message
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Perform a security-sensitive operation, hashing the message
                byte[] hash = md.digest(message.getBytes());
                String secureMessage = new String(hash);
                System.out.println("Secured message: " + secureMessage);

                // Echo the secure message back to the client
                dos.writeUTF(secureMessage);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}