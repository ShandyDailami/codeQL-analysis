import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00575_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                break;
            }

            byte[] response = "Hello, client!".getBytes();
            outputStream.write(response);
            outputStream.flush();
            System.out.println("Server replied with: " + new String(buffer, 0, bytesRead));
        }

        server.close();
    }
}