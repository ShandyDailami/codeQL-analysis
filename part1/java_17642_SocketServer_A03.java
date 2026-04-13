import java.io.*;
import java.net.*;

public class java_17642_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client accepted");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Read username and password from client
        String clientMsg = dis.readUTF();

        // Hard-coded username and password for testing
        String username = "admin";
        String password = "password";

        if(clientMsg.equals(username) && clientMsg.equals(password)) {
            System.out.println("Authorized access!");
            dos.writeUTF("Access granted");
        } else {
            System.out.println("Access denied!");
            dos.writeUTF("Access denied");
        }

        dos.close();
        socket.close();
        server.close();
    }
}