import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class java_14073_SocketServer_A07 {
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for a client...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientInput = dataInputStream.readUTF();
            if (clientInput.startsWith("register")) {
                String username = clientInput.split(" ")[1];
                String password = clientInput.split(" ")[2];
                users.put(username, password);
                dataOutputStream.writeUTF("Registered successfully");
            } else if (clientInput.startsWith("login")) {
                String username = clientInput.split(" ")[1];
                String password = clientInput.split(" ")[2];
                if (users.containsKey(username) && users.get(username).equals(password)) {
                    dataOutputStream.writeUTF("Logged in successfully");
                } else {
                    dataOutputStream.writeUTF("Login failed");
                }
            } else {
                dataOutputStream.writeUTF("Invalid request");
            }

            dataOutputStream.close();
            socket.close();
        }
    }
}