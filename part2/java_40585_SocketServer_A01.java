import java.io.*;
import java.net.*;

public class java_40585_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket socket = serverSocket.accept();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String request = inputStream.readUTF();

            if (request.equalsIgnoreCase("Hello")) {
                outputStream.writeUTF("Hello Client, you are connected to the server!");
            } else {
                outputStream.writeUTF("Invalid request, please enter 'Hello'.");
            }

            outputStream.close();
            inputStream.close();
            socket.close();
        }
    }
}