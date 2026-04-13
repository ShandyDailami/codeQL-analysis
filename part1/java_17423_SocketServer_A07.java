import java.io.*;
import java.net.*;

public class java_17423_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(5000);
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client accepted!");
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            if ("A07_AuthFailure".equals(request)) {
                out.writeUTF("Authentication failed");
                out.flush();
            } else {
                out.writeUTF("Request processed successfully");
                out.flush();
            }

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}