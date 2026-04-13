import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18391_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for a client to connect...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Here you would typically handle the data exchange
            // For simplicity, we'll just echo back the message to the client
            while (true) {
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);
                System.out.println("Received: " + message);
                socket.getOutputStream().write(message.getBytes());
           .
            .
            .
            // End of code for handling data exchange

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}