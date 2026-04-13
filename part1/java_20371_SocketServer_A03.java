import java.io.*;
import java.net.*;
import java.util.*;

public class java_20371_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected...");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Server says: Hello, client!";
            dos.writeUTF(serverMessage);
            dos.flush();

            socket.close();
        }
    }
}