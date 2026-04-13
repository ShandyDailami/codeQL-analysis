import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06323_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is running and waiting for a client to connect...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("A client has connected!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            message = "Hello Client, Welcome!";
            out.writeUTF(message);
            out.flush();

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}