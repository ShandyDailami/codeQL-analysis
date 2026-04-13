import java.io.*;
import java.net.*;
import java.util.*;

public class java_14039_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message = dataInputStream.readUTF();
                System.out.println("Received message: " + message);

                String response = "Server response: " + message;
                dataOutputStream.writeUTF(response);
                System.out.println("Sent response: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}