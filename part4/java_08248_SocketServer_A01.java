import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08248_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // create a reader to read the message from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // write a response to the client
            OutputStream writer = socket.getOutputStream();
            writer.write("Hello Client!".getBytes());

            // read a message from the client
            String message = reader.readLine();
            System.out.println("Received message: " + message);

            // close the connection
            socket.close();
        }
    }
}