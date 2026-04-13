import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17190_SocketServer_A07 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String request = inputStream.readUTF();
                System.out.println("Received request: " + request);

                // Simulate authentication failure
                if (!authenticate(request)) {
                    outputStream.writeUTF("Auth failure");
                    outputStream.flush();
                    socket.close();
                    continue;
                }

                outputStream.writeUTF("Auth success");
                outputStream.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String request) {
        // Simulate authentication by checking if the request is a known user
        return request.equals("user1") || request.equals("user2");
    }
}