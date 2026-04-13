import java.io.*;
import java.net.*;

public class java_39368_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8888);
        System.out.println("Server started at port 8888...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Connected with client at " + client.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=utf-8\r\n" +
                    "\r\n" +
                    "<h1>Hello, World!</h1>";

            dos.writeUTF(response);
            dos.flush();

            client.close();
        }
    }
}