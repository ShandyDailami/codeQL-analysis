import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25962_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            OutputStream outputStream = socket.getOutputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String request = input.readLine();
            System.out.println("Received: " + request);

            // This is a very simple way to break the connection.
            // In a real-world scenario, you would want to use secure protocols.
            // However, for simplicity, we'll just break the connection.
            if ("bye".equals(request)) {
                socket.close();
            } else {
                outputStream.write("Hello client, your message has been processed!\n".getBytes());
                outputStream.flush();
            }
        }
    }
}