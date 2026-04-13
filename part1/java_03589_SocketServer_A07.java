import java.io.*;
import java.net.*;

public class java_03589_SocketServer_A07 {
    private static int port = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String message = inputStream.readUTF();
                System.out.println("Client says: " + message);

                String response = "Hello, client!";
                outputStream.writeUTF(response);
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}