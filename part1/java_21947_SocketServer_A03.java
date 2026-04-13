import java.io.*;
import java.net.*;

public class java_21947_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);

        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client " + socket.getInetAddress() + " connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();

            // Inject code here
            String injectedMessage = "Injected message: " + message;

            dataOutputStream.writeUTF(injectedMessage);
            dataOutputStream.flush();

            socket.close();
        }
    }
}