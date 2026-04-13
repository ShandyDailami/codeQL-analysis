import java.io.*;
import java.net.*;

public class java_34965_SocketServer_A03 {
    private static final String DEFAULT_RESPONSE = "Welcome to the SocketServer!\n";
    private static final String PASSWORD = "1234"; // Change this to a real password

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5555);

        System.out.println("Server is listening on port 5555...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected...");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            String response = handleRequest(clientMessage);

            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }

    private static String handleRequest(String request) {
        if (request.equals(PASSWORD)) {
            return DEFAULT_RESPONSE;
        } else {
            return "Access denied!";
        }
    }
}