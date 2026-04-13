import java.net.*;
import java.io.*;

public class java_40151_SocketServer_A08 {
    private ServerSocket serverSocket;
    private Socket socket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        socket = serverSocket.accept();
        System.out.println("Client connected: " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received: " + message);

        message = caesarCipher(message, 3); // Caesar cipher

        out.writeUTF(message);
        out.close();
        socket.close();
        serverSocket.close();
    }

    private static String caesarCipher(String message, int shift) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char)(((int)c + shift - 65) % 26 + 65);
                } else {
                    c = (char)(((int)c + shift - 97) % 26 + 97);
                }
            }
            output.append(c);
        }
        return output.toString();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start(1234);
    }
}