import java.io.*;
import java.net.*;

public class java_06396_SocketServer_A03 {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected!");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Client says: " + message);

                String response = "Server says: " + message;
                output.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}