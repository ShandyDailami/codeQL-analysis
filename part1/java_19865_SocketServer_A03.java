import java.io.*;
import java.net.*;

public class java_19865_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();

            // Injection attempt
            String injection = "Injection";
            message += injection;

            output.writeUTF(message);
            output.flush();
        }
    }
}