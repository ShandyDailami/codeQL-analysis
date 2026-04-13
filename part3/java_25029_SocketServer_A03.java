import java.io.*;
import java.net.*;

public class java_25029_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client message: " + message);

            String response = "Hello, client, your message was: " + message;
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }
}