import java.net.*;
import java.io.*;

public class java_38285_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for connection on port 1234...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // read username and password from client
        String username = in.readUTF();
        String password = in.readUTF();

        // verify the credentials
        if ("username".equals(username) && "password".equals(password)) {
            out.writeUTF("Authentication successful");
        } else {
            out.writeUTF("Authentication failed");
       
        }

        socket.close();
        server.close();
    }
}