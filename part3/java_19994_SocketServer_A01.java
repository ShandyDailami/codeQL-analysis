import java.net.*;
import java.io.*;

public class java_19994_SocketServer_A01 {

    private static final String PORT_NUMBER = "1234";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(PORT_NUMBER));

        while (true) {
            System.out.println("Waiting for a client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // First, we read the length of the message
            int length = dataInputStream.readInt();
            byte[] messageBytes = new byte[length];
            dataInputStream.readFully(messageBytes, 0, length);

            String message = new String(messageBytes, "UTF-8");
            System.out.println("Received message: " + message);

            dataOutputStream.writeUTF("Thank you for connecting to server. Your message was: " + message);

            dataOutputStream.flush();

            socket.close();
        }
    }
}