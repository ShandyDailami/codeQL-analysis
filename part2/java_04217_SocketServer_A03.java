import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04217_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message = dataInputStream.readUTF();
                System.out.println("Received message: " + message);

                // You can apply any security-sensitive operation here
                // For example, you can check the message for injection attacks
                if (message.contains("bad_input")) {
                    System.out.println("Bad input detected. Denying connection...");
                    dataOutputStream.writeUTF("Connection denied due to bad input.");
                    dataOutputStream.close();
                    socket.close();
                    continue;
                }

                String response = "Hello, client, your message was received successfully.";
                dataOutputStream.writeUTF(response);
                dataOutputStream.flush();
                dataOutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}