import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09201_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                DataInputStream input = new DataInputStream(client.getInputStream());
                DataOutputStream output = new DataOutputStream(client.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                output.writeUTF("Message received");
                output.flush();

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}