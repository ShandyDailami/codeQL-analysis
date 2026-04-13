import java.io.*;
import java.net.*;

public class java_19435_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String message = in.readLine();
            System.out.println("Received: " + message);
            out.writeBytes("Hello client, your message was: " + message + "\n");
            socket.close();
        }
    }
}