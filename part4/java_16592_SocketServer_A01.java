import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16592_SocketServer_A01 {

    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port: " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Client message: " + clientMessage);

                // Add your security rules here
                // For instance, verify client's identity
                if (clientMessage.startsWith("verify ")) {
                    String[] clientInfo = clientMessage.split(" ");
                    if (clientInfo[1].equals("password")) {
                        dataOutputStream.writeUTF("Access granted");
                    } else {
                        dataOutputStream.writeUTF("Access denied");
                    }
                }

                // End of security rules

                dataOutputStream.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}