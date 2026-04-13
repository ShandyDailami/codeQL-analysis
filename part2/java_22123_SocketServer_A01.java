import java.io.*;
import java.net.*;

public class java_22123_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            String response = "Hello, Client";
            out.writeUTF(response);
            out.close();
            in.close();
            socket.close();
       
        }
    }
}