import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21509_SocketServer_A01 {

    private static final int PORT = 9000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String message = inputStream.readUTF();
                System.out.println("Received: " + message);

                // Implementing security-sensitive operations
                // Assuming a simple echo-based protocol.
                if (message.equals("BREAK")) {
                    outputStream.writeUTF("ACCESS_DENIED");
                } else {
                    outputStream.writeUTF("ACCESS_GRANTED");
                }

                outputStream.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}