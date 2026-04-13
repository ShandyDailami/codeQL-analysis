import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09408_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message = dataInputStream.readUTF();
                System.out.println("Received message from client: " + message);

                String response = "Hello, client!";
                dataOutputStream.writeUTF(response);
                System.out.println("Sent response to client: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}