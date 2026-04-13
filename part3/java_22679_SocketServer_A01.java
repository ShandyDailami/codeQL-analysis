import java.io.*;
import java.net.*;

public class java_22679_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Waiting for client on port 8000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            dos.writeUTF("HTTP/1.1 200 OK");
            dos.writeUTF("Content-Type: text/html; charset=utf-8");
            dos.writeUTF("");

            String html = "<html><body>Hello, this is a secure server.</body></html>";
            dos.writeUTF(html);
            dos.writeUTF("");

            socket.close();
        }
    }
}