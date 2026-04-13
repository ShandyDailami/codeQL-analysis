import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36745_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream writer = socket.getOutputStream();

            String receivedMessage = reader.readLine();
            System.out.println("Received message: " + receivedMessage);

            String expectedMessage = "Hello, client!";
            if (receivedMessage.equals(expectedMessage)) {
                writer.write("Server: Message received, processing..." + System.lineSeparator());
                writer.flush();
            } else {
                System.out.println("Integrity failure detected, closing connection");
                writer.write("Server: Integrity failure detected, closing connection" + System.lineSeparator());
                writer.flush();
                socket.close();
            }
        }
    }
}