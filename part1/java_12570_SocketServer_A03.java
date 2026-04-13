import java.io.*;
import java.net.*;

public class java_12570_SocketServer_A03 {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("Connection established, thank you!");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}