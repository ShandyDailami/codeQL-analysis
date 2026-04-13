import java.io.*;
import java.net.*;

public class java_25665_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create new input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive client's request
            String request = dis.readUTF();
            System.out.println("Client's request: " + request);

            // Send response
            String response = "Hello, you sent: " + request;
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}