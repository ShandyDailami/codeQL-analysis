import java.io.*;
import java.net.*;

public class java_32570_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);

            // Here we're assuming the message only contains alphanumeric characters for simplicity.
            // In a real-world application, you would probably want to parse and validate the input,
            // but this is the most basic way to handle a simple string injection attack.
            if (message.contains("DROP TABLE")) {
                dataOutputStream.writeUTF("Attempted table injection, please do not try to drop the table.");
                dataOutputStream.flush();
            } else {
                dataOutputStream.writeUTF("Successful connection.");
                dataOutputStream.flush();
            }

            socket.close();
        }
    }
}