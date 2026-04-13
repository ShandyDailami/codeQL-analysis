import java.io.*;
import java.net.*;

public class java_12271_SocketServer_A08 {

    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("Bye")) {
                output.writeUTF("Goodbye");
                output.flush();
            } else {
                output.writeUTF("Hello, Client");
                output.flush();
           
                byte[] bytes = message.getBytes();
                int start = 0;
                int end = 0;

                while ((end = input.read(bytes, start, bytes.length)) != -1) {
                    output.write(bytes, start, end);
                    output.flush();
                }
            }

            socket.close();
        }
    }
}