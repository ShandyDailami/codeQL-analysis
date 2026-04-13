import java.io.*;
import java.net.*;

public class java_32376_SocketServer_A07 {
    private static final String SERVER_MESSAGE = "Hello, client!";
    private static boolean authenticationFailed = false;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            if (authenticationFailed) {
                dataOutputStreamAuthenticationFailed(dataOutputStream);
            } else {
                dataOutputStreamSuccess(dataOutputStream);
            }

            socket.close();
        }
    }

    private static void dataOutputStreamSuccess(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(SERVER_MESSAGE);
    }

    private static void dataOutputStreamAuthenticationFailed(DataOutputStream dataOutputStream) throws IOException {
        authenticationFailed = true;
        dataOutputStream.writeUTF("Authentication failed. Please try again.");
    }
}