import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11641_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is running on port 1234...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected...");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // read the client's request
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            String request = new String(bytes, 0, length);

            // send a response back to the client
            String response = "Hello, client!";
            outputStream.write(response.getBytes());

            socket.close();
        }
    }
}