import java.io.*;
import java.net.*;

public class java_42023_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            byte[] buffer = new byte[1024];
            int bytesRead = dis.read(buffer);

            if (checkIntegrity(buffer, bytesRead)) {
                dos.writeUTF("Integrity failure detected in data");
            } else {
                dos.writeUTF("Data is valid");
           
            }

            socket.close();
        }
    }

    private static boolean checkIntegrity(byte[] buffer, int length) {
        // Simulate integrity failure here by checking the last byte of the buffer
        return buffer[length - 1] != 0;
    }
}