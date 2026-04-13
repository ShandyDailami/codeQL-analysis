import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36646_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server started on port 6000");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(client.getInputStream());
                DataOutputStream output = new DataOutputStream(client.getOutputStream());

                // read the username from the client
                String username = input.readUTF();
                System.out.println("Username received: " + username);

                // write a welcome message back to the client
                output.writeUTF("Welcome " + username + " !");
                output.flush();

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}