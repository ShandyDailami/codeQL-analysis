import java.io.*;
import java.net.*;

public class java_38145_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted a new client.");
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

            byte[] bytes = new byte[1024];
            int length = dataIn.read(bytes, 0, 1024);

            if (length == -1) {
                System.out.println("Client disconnected.");
                socket.close();
            } else {
                String message = new String(bytes, 0, length);
                System.out.println("Received message: " + message);
                dataOut.writeUTF("ACK " + message);
                dataOut.flush();
            }
        }
    }
}