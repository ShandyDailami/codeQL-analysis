import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24369_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080, 100, InetAddress.getByName("127.0.0.1"));
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                socket.close();
            } else {
                System.out.println("Received message: " + new String(buffer, 0, bytesRead));

                // For the sake of example, just echo back the message
                outputStream.write(buffer, 0, bytesRead);
                outputStream.flush();
            }
        }
    }
}