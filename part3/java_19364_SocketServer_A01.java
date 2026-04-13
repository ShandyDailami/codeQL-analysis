import java.io.*;
import java.net.*;

public class java_19364_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected...");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());

                String clientMessage = in.readUTF();
                System.out.println("Received from client: " + clientMessage);

                String serverMessage = "Hello Client, you connected successfully!";
                out.writeUTF(serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}