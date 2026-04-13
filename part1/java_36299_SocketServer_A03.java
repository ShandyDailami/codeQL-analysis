import java.io.*;
import java.net.*;

public class java_36299_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Here you can add your security-sensitive operations related to A03_Injection

            output.writeUTF("Message received!");
            output.flush();
       
            socket.close();
        }
    }
}