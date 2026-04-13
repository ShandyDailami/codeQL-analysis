import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_26969_SocketServer_A07 {
    private static final String SERVER_USERNAME = "admin";
    private static final String SERVER_PASSWORD = "password";

    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put(SERVER_USERNAME, SERVER_PASSWORD);

        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                try (DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                    String clientUsername = input.readUTF();
                    String clientPassword = input.readUTF();

                    if (!users.get(clientUsername).equals(clientPassword)) {
                        output.writeUTF("AuthFailure");
                        output.flush();
                    } else {
                        output.writeUTF("AuthSuccess");
                        output.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}