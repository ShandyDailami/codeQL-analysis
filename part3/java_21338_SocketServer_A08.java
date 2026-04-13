import java.io.*;
import java.net.*;

public class java_21338_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                if (message.equals("exit")) {
                    out.writeUTF("Connection closed by client");
                    socket.close();
                    break;
                }
                System.out.println("Received: " + message);
                out.writeUTF("Message received");
            }
            socket.close();
        }
    }
}