import java.io.*;
import java.net.*;

public class java_00324_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 4445;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("A client has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Server says: Hello, client!";
                out.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}