import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32894_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started!");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Authentication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String username = in.readUTF();
                String password = in.readUTF();

                // Assuming correct username and password
                if (username.equals("test") && password.equals("test")) {
                    out.writeUTF("Authentication successful");
                    out.flush();
                } else {
                    out.writeUTF("Authentication failed");
                    out.flush();
                    continue;
                }

                // Encryption
                String plainText = in.readUTF();
                String encryptedText = encryptText(plainText);

                out.writeUTF(encryptedText);
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String encryptText(String text) {
        // Here we're just returning the original text, but you can replace this with a real encryption logic
        return text;
    }
}