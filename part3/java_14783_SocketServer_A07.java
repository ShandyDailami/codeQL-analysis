import java.io.*;
import java.net.*;

public class java_14783_SocketServer_A07 {
    private static final int PORT = 4000;
    private static final String AUTH_FAILURE_MESSAGE = "Authentication failure.";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());

                String clientMessage = inputStream.readUTF();
                System.out.println("Received message from client: " + clientMessage);

                if (isAuthFailure(clientMessage)) {
                    outputStream.writeUTF(AUTH_FAILURE_MESSAGE);
                    outputStream.flush();
                    System.out.println("Sent auth failure message back to client");
                } else {
                    outputStream.writeUTF("Authentication successful.");
                    outputStream.flush();
                    System.out.println("Sent successful message back to client");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isAuthFailure(String message) {
        return message.equals("Auth Failure");
    }
}