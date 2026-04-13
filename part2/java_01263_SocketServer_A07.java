import java.net.*;
import java.io.*;
import java.util.*;

public class java_01263_SocketServer_A07 {
    private static final int PORT = 8080;
    private static final String AUTH_FAILURE_MSG = "Authentication failure!";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            handleClient(socket);
            socket.close();
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        System.out.println("Waiting for message...");
        String message = inputStream.readUTF();
        System.out.println("Received: " + message);

        if (message.equals("fail")) {
            outputStream.writeUTF(AUTH_FAILURE_MSG);
            outputStream.flush();
            System.out.println("Sent: " + AUTH_FAILURE_MSG);
        } else {
            outputStream.writeUTF("Success");
            outputStream.flush();
            System.out.println("Sent: Success");
        }
    }
}