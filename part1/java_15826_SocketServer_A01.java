import java.io.*;
import java.net.*;

public class java_15826_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            // create streams for communication
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // receive and send data
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client, you are connected to secure server";
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}