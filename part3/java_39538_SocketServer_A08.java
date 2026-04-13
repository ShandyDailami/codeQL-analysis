import java.io.*;
import java.net.*;

public class java_39538_SocketServer_A08 {
    private ServerSocket server;

    public void startServer(int port) throws IOException {
        server = new ServerSocket(port);
        while (true) {
            Socket client = server.accept();
            handleClient(client);
        }
    }

    private void handleClient(Socket client) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                if (message.equals("close")) {
                    writer.println("bye");
                    client.close();
                    break;
                } else {
                    // Encrypt the message for security
                    String encryptedMessage = encrypt(message);
                    writer.println(encryptedMessage);
                }
            }

            writer.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This is a very basic encryption method for the sake of the example
    private String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            encryptedMessage.append((char) (ch + 1));
        }
        return encryptedMessage.toString();
    }

    public static void main(String[] args) {
        try {
            MyServer server = new MyServer();
            server.startServer(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}