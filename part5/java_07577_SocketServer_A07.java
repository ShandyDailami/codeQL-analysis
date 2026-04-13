import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07577_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Read from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Received message: " + message);

            // Send back in reverse order
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println("Received your message: " + message.split(" ")[1] + " " + message.split(" ")[0]);

            clientSocket.close();
        }
    }
}