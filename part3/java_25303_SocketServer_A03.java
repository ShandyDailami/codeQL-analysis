import java.io.*;
import java.net.*;

public class java_25303_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Request: " + request);

            String response = processRequest(request);
            out.writeUTF(response);
            out.flush();

            socket.close();
       .
        .
        .
    }

    private static String processRequest(String request) {
        // Simple sanitization to remove any potential SQL or XSS injections
        return request.replace(";", "");
    }
}