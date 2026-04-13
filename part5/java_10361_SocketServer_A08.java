import java.io.*;
import java.net.*;

public class java_10361_SocketServer_A08 {
    private static final String HANDSHAKE_MESSAGE = "HTTP/1.1 200 OK\r\n" +
            "Date: " + new Date() + "\r\n" +
            "Server: Java Secure Server/1.0\r\n" +
            "Content-Type: text/plain; charset=utf-8\r\n" +
            "Content-Length: 13\r\n\r\n" +
            "Secure Connection OK";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket client = server.accept();

            // Perform handshake with the client
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            out.writeUTF(HANDSHAKE_MESSAGE);
            out.flush();

            System.out.println("Sent handshake response");

            client.close();
        }
    }
}