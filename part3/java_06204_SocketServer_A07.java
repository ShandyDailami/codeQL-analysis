import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06204_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // Port 1234 is arbitrary
        System.out.println("Server is listening on port 1234...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = input.readUTF()) != null) {
                System.out.println("Received message: " + message);

                // Respond with a message back to the client
                output.writeUTF("Message received: " + message);
            }

            socket.close();
        }
    }
}