import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27457_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                // Send a secure message to the client
                outputStream.writeUTF("Hello, Client!");
                outputStream.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}