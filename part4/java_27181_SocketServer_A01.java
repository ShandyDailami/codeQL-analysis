import java.io.*;
import java.net.*;

public class java_27181_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started at port 5000.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, client!";
            output.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
        }
    }
}