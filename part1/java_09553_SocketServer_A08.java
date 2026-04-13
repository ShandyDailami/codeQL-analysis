import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09553_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStream writer = socket.getOutputStream();

        String clientMessage;
        while ((clientMessage = reader.readLine()) != null) {
            if (clientMessage.equals("invalid message")) {
                writer.write("Failure: Invalid message received.\n".getBytes());
            } else {
                writer.write("Welcome, client!\n".getBytes());
            }
            writer.flush();
        }

        serverSocket.close();
    }
}