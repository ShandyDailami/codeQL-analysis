import java.io.*;
import java.net.*;

public class java_02222_SocketServer_A07 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port: " + 8080);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Step 1: Reading from client
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String message = dataInputStream.readUTF();
                System.out.println("Received from client: " + message);

                // Step 2: Processing (Security-sensitive operation, A07_AuthFailure)
                // In this case, we're just validating the message.
                if ("secure message".equals(message)) {
                    System.out.println("Validated message, proceeding.");
                } else {
                    System.out.println("Invalid message, authentication failure.");
                    // Step 2a: Sending response
                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                    dataOutputStream.writeUTF("auth failure");
                    dataOutputStream.flush();
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}