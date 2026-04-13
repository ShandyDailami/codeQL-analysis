import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class java_32156_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        // Step 1: Initialize a new Socket
        Socket socket = new Socket("localhost", PORT);

        // Step 2: Initialize InputStream and OutputStream
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // Step 3: Handle the connection
        System.out.println("Connected to the server!");

        // Step 4: Write a message to the server
        String message = "Hello, server!";
        byte[] messageBytes = message.getBytes();
        outputStream.write(messageBytes);
        outputStream.flush();

        // Step 5: Read a message from the server
        byte[] serverMessage = new byte[1000];
        inputStream.read(serverMessage);

        // Step 6: Close the connection
        socket.close();

        // Step 7: Print the received message
        System.out.println("Received message from server: " + new String(serverMessage));
    }
}