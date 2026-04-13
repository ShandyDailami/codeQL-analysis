import java.io.*;
import java.net.*;

public class java_39664_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read from the client
            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);

            // Send a response
            dataOutputStream.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());

            socket.close();
        }
    }
}