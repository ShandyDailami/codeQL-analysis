import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27321_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is running...");

            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}