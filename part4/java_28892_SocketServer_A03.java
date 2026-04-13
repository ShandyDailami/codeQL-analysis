import java.io.*;
import java.net.*;

public class java_28892_SocketServer_A03 {
    private static final String SERVER_MSG = "Server Message: ";
    private static final String CLIENT_MSG = "Client Message: ";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message = dataInputStream.readUTF();
                System.out.println(CLIENT_MSG + message);

                String response = "Message received successfully";
                dataOutputStream.writeUTF(response);
                dataOutputStream.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}