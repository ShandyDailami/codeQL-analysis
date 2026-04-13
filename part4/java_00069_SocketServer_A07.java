import java.net.*;
import java.io.*;

public class java_00069_SocketServer_A07 {
    private static int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("auth")) {
                String response = "Success";
                out.writeUTF(response);
            } else {
                String response = "Fail";
                out.writeUTF(response);
           
            }

            out.close();
            socket.close();
        }
    }
}