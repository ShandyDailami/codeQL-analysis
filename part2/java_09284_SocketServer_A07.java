import java.net.*;
import java.io.*;

public class java_09284_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read the message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // send back the message to client
            out.writeUTF("Server received: " + message);
            out.flush();

            socket.close();
        }
    }
}