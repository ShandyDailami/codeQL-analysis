import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12596_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // create buffered reader for incoming client message
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // create print writer for outgoing client message
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // forward client message to connected client
                writer.println(clientMessage);
            }

            socket.close();
        }
    }
}