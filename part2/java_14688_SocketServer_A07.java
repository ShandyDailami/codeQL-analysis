import java.net.*;
import java.io.*;

public class java_14688_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        int port = 4445;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is listening on port " + port);

        Socket socket = serverSocket.accept();

        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String clientMessage;

        do {
            clientMessage = dis.readUTF();
            System.out.println("Received client message: " + clientMessage);

            dos.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");
        } while (true);
   
        // serverSocket.close();
    }
}