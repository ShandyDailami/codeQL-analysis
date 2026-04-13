import java.io.*;
import java.net.*;

public class java_12854_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading the request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Sending the response
            String response = "Hello, client!";
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }
}