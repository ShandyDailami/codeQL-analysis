import java.io.*;
import java.net.*;

public class java_07672_SocketServer_A07 {
    private static final int PORT = 8080;
    private static boolean running = true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (running) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted a connection from " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);

            // Simulate a failure due to authentication
            if (message.equals("auth_failure")) {
                dataOutputStream.writeUTF("authentication_failure");
                dataOutputStream.flush();
                System.out.println("Sent: authentication_failure");
            } else {
                dataOutputStream.writeUTF("success");
                dataOutputStream.flush();
                System.out.println("Sent: success");
            }

            socket.close();
        }

        serverSocket.close();
    }
}