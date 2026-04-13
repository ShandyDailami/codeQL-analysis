import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_19034_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                continue;
            }

            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + message);

            String response = "Hello, client";
            output.write(response.getBytes());

            socket.close();
        }
    }
}