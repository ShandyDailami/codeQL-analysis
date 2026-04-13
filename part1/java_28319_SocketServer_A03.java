import java.io.*;
import java.net.*;

public class java_28319_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);

        while (true) {
            Socket socket = serverSocket.accept();

            // Read from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();

            // Echo the message back to the client
            out.writeUTF(clientMessage);
            out.flush();

            socket.close();
        }
    }
}