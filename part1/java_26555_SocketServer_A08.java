import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26555_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Handling client connection by creating a new thread
                new Thread(() -> handleClient(dataInputStream, dataOutputStream)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        try {
            while (true) {
                String message = dataInputStream.readUTF();
                System.out.println("Received: " + message);

                // Simulate integrity failure
                if (message.equals("fail")) {
                    throw new RuntimeException("Integrity failure");
                }

                dataOutputStream.writeUTF("Message received");
                dataOutputStream.flush();
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
    }
}