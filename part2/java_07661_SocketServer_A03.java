import java.io.*;
import java.net.*;

public class java_07661_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            String response = "HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html; charset=utf-8\n\n" + // Return a simple HTML response
                    "<h1>Hello, World!</h1>";

            out.writeUTF(response);
            System.out.println("Sent response");

            socket.close();
        }
    }
}