import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30657_SocketServer_A03 {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String data = input.readUTF();
                System.out.println("Received: " + data);
                output.writeUTF("Thank you for connecting");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}