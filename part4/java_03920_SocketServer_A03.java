import java.net.*;
import java.io.*;

public class java_03920_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Server is listening on port 9000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client is connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message = dataInputStream.readUTF();
                System.out.println("Received message: " + message);

                String response = "Hello, client!";
                dataOutputStream.writeUTF(response);
                System.out.println("Sent response: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}