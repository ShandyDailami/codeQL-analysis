import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16787_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        // Step 1: Bind the server to the port
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started.");

        while (true) {
            // Step 2: Accept client
            Socket socket = serverSocket.accept();

            // Step 3: Communicate with client
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello from server!".getBytes());
            outputStream.flush();

            socket.close();
        }
    }
}