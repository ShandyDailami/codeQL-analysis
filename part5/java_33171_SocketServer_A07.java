import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33171_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Set up input and output streams
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                // Read the command from the client
                byte[] buffer = new byte[1024];
                int bytesRead = in.read(buffer);
                String command = new String(buffer, 0, bytesRead);

                // Send a welcome message back to the client
                out.write("Welcome to the server!\n".getBytes());

                // Now we just echo back the command
                out.write(command.getBytes());
                out.write("\n".getBytes());
            }
        }
    }
}