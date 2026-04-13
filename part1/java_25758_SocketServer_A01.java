import java.io.*;
import java.net.*;

public class java_25758_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for a client...");
        Socket sock = server.accept();
        System.out.println("Accepted connection from " + sock.getRemoteSocketAddress());

        DataInputStream dis = new DataInputStream(sock.getInputStream());
        DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

        // Simulate a security-sensitive operation (BrokenAccessControl).
        String clientData = dis.readUTF();
        System.out.println("Received: " + clientData);

        // Reply with a password (not real password, just for demonstration).
        String response = "Your password is: 123456";
        dos.writeUTF(response);
        dos.flush();

        sock.close();
    }
}