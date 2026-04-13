import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41253_SocketServer_A03 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Simulate a security sensitive operation related to A03_Injection
            int n = input.read();
            if (n == 'A') {
                output.write("A03_Injection attempt detected! Access denied.".getBytes());
            } else {
                output.write("Access granted.".getBytes());
            }

            socket.close();
        }
    }
}