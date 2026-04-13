import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01633_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            // Use BufferedReader and PrintWriter for read/write operations
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);

                // TODO: Add your security-sensitive operations here.

                // For example, we're just sending back the received request
                writer.println(request);
            }

            socket.close();
        }
    }
}