import java.io.*;
import java.net.*;

public class java_30189_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started. Listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Assuming if the message contains 'badword' then it is spam
            if (message.contains("badword")) {
                output.writeUTF("Spam detected");
            } else {
                output.writeUTF("Message accepted");
            }

            output.close();
            socket.close();
        }
    }
}