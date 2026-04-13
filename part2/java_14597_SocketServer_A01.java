import java.io.*;
import java.net.*;

public class java_14597_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected");

                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                String message = dataInputStream.readUTF();
                System.out.println("Received message from client: " + message);

                String response = "Hello, client!";
                dataOutputStream.writeUTF(response);
                System.out.println("Sent response back to client: " + response);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}