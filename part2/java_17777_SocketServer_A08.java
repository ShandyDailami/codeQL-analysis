import java.io.*;
import java.net.*;

public class java_17777_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("exit")) {
                out.writeUTF("exit");
                out.close();
                socket.close();
            } else {
                out.writeUTF("Thank you for connecting");
            }
        }
    }
}