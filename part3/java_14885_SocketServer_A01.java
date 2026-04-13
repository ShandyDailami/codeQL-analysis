import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_14885_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept()) {

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);

            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                return;
            }

            String response = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + response);

            String responseMessage = "Message received";
            out.write(responseMessage.getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}