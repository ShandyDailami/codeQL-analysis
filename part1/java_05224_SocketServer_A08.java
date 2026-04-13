import java.io.*;
import java.net.*;

public class java_05224_SocketServer_A08 {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // receive a byte
            byte receivedByte = in.readByte();

            // XOR the byte with a fixed byte
            byte xorKey = 0x42; // any byte that is not used in data or encryption
            byte encryptedByte = (byte) (receivedByte ^ xorKey);

            // send the encrypted byte back to the client
            out.writeByte(encryptedByte);
            out.flush();

            clientSocket.close();
        }
    }
}