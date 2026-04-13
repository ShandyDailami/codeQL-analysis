import java.io.*;
import java.net.*;

public class java_21253_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        while(true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Connection established. Type your message and press Enter.");

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = inputStream.readLine();
            System.out.println("Client said: " + message);

            socket.close();
        }
    }
}