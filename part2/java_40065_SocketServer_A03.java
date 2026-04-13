import java.io.*;
import java.net.*;
import java.util.*;

public class java_40065_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            String response = "Hello, " + request;
            out.writeUTF(response);

            out.close();
            in.close();
            socket.close();
        }
    }
}