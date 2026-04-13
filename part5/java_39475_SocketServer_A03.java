import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39475_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                Socket socket = server.accept();
                InputStream input = socket.getInputStream();
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Create a new thread for each connection
                new Thread(() -> handleRequest(input, output)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(InputStream input, DataOutputStream output) {
        try {
            byte[] buffer = new byte[1024];
            int bytes = input.read(buffer);
            if (bytes != -1) {
                String response = new String(buffer, 0, bytes);
                output.write(("HTTP/1.1 200 OK\r\n\r\n" + response).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}