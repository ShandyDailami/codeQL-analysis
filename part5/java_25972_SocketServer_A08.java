import java.io.*;
import java.net.*;

public class java_25972_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = inputStream.readUTF();

            // If request is not the same as expected, send failure response
            if (!request.equals("Expected Request")) {
                outputStream.writeUTF("Failure Response");
                outputStream.flush();
            } else {
                outputStream.writeUTF("Success Response");
                outputStream.flush();
            }

            socket.close();
        }
    }
}