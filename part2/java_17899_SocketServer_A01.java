import java.io.*;
import java.net.*;

public class java_17899_SocketServer_A01 {

    private static final String PASSWORD = "secure";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Check if password is correct
                DataInputStream input = new DataInputStream(socket.getInputStream());
                String received = input.readUTF();
                if (!PASSWORD.equals(received)) {
                    System.out.println("Incorrect password, client disconnected");
                    socket.close();
                    continue;
                }

                // Process request
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Hello, client, you are authenticated!");
                output.flush();
                System.out.println("Sent message: " + "Hello, client, you are authenticated!");
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
}