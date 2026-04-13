import java.io.*;
import java.net.*;

public class java_19230_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("A08_IntegrityFailure")) {
                out.writeUTF("Success");
            } else {
                out.writeUTF("Failure");
           
            }

            out.close();
            socket.close();
        }
    }
}