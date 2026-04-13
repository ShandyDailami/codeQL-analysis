import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02196_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Here, you can add code to handle the connection securely, such as:
            // InputStream inputStream = socket.getInputStream();
            // BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // String message = reader.readLine();
            // System.out.println("Client says: " + message);

            // Send a response
            // OutputStream outputStream = socket.getOutputStream();
            // PrintWriter writer = new PrintWriter(outputStream, true);
            // writer.println("Hello client, you connected successfully!");

            socket.close();
        }
    }
}