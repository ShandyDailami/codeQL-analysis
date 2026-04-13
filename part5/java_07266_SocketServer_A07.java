import java.io.*;
import java.net.*;

public class java_07266_SocketServer_A07 {
    private static final String PASSWORD = "secure";
    private static boolean authenticated = false;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is running and waiting for connections...");

        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            if (authenticate(socket)) {
                handleRequest(socket);
            } else {
                closeConnection(socket);
            }
        }

        serverSocket.close();
    }

    private static boolean authenticate(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        System.out.println("Enter password:");
        String input = in.readUTF();

        if (input.equals(PASSWORD)) {
            out.writeUTF("OK");
            authenticated = true;
        } else {
            out.writeUTF("FAIL");
            authenticated = false;
        }

        out.flush();
        return authenticated;
    }

    private static void handleRequest(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        System.out.println("Received request: " + in.readUTF());
        out.writeUTF("OK");

        out.flush();
    }

    private static void closeConnection(Socket socket) throws IOException {
        socket.close();
        System.out.println("Connection closed");
    }
}