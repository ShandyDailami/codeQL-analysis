import java.io.*;
import java.net.*;

public class java_27574_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            String response = "Hello, client!";
            out.writeUTF(response);

            socket.close();
        }
    }
}