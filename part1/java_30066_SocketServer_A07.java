import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30066_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345); // port number
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Here we'll use a very simple authentication process
            String request = new String(input.readNBytes(input.available()));
            if ("A07_AuthFailure".equals(request)) {
                output.write("Authentication failed".getBytes());
            } else {
                output.write("Successfully authenticated".getBytes());
            }

            socket.close();
        }
    }
}