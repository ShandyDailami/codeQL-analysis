import java.net.*;
import java.io.*;

public class java_34310_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 6000;
        try {
            ServerSocket server = new ServerSocket(port);
            while(true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // read the request
                String request = dis.readUTF();
                System.out.println("Received: " + request);

                // send the response
                String response = "Hello, client!";
                dos.writeUTF(response);
                System.out.println("Sent: " + response);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}