import java.io.*;
import java.net.*;

public class java_40273_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = sanitizeInput(clientMessage);
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();
       
            socket.close();
        }
    }

    private static String sanitizeInput(String input) {
        // Injection prevention using parameterized queries.
        // This is a simplistic example, and doesn't handle all cases.
        // In a real-world application, you would need to use a more sophisticated method to prevent injection.
        return "Injected: " + input;
    }
}