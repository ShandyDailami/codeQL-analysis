import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20325_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received client message: " + clientMessage);

                String response = handleClientMessage(clientMessage);

                dataOutputStream.writeUTF(response);
                dataOutputStream.flush();
                dataOutputStream.close();
                dataInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String handleClientMessage(String clientMessage) {
        // Simple injection prevention by disallowing certain operations
        if (clientMessage.contains("drop table")) {
            return "Attempted to drop table, denied.";
        }

        // Simple encryption by converting characters to ASCII and shifting them
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : clientMessage.toCharArray()) {
            encryptedMessage.append((int) c + 1);
        }

        return encryptedMessage.toString();
    }
}