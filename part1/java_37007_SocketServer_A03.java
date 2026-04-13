import java.io.*;
import java.net.*;
import java.util.*;

public class java_37007_SocketServer_A03 {
    private static int port = 1234;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client accepted from " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            String response = handleMessage(message);

            out.writeUTF(response);
            out.flush();
          }
    }

    private static String handleMessage(String message) {
        // Here you can add your own security-sensitive operations
        // This is just a demonstration of how you can use standard libraries
        // Do not use external frameworks like Spring or Hibernate
        // A03_Injection: This is not a security-sensitive operation, but demonstrates how to read data from a stream

        String[] words = message.split(" ");
        List<String> upperWords = new ArrayList<>();

        for (String word : words) {
            upperWords.add(word.toUpperCase());
        }

        return String.join(" ", upperWords);
    }
}