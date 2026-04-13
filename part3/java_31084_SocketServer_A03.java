import java.io.*;
import java.net.*;

public class java_31084_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4444);

        System.out.println("Server started at port 4444");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();

            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, Client!";

            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();

            socket.close();
       
        }
    }
}