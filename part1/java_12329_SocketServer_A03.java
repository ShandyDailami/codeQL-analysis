import java.io.*;
import java.net.*;

public class java_12329_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String request = input.readUTF();
                System.out.println("Received: " + request);

                // A03_Injection
                String command = "Command: " + request;
                output.writeUTF(command);
                output.flush();

                System.out.println("Sent: " + command);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}