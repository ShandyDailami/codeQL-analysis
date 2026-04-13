import java.io.*;
import java.net.*;

public class java_27815_SocketServer_A01 {
    private static final String SERVER_MESSAGE = "Thank you for connecting to the server!";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("A client has connected!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            out.writeUTF(SERVER_MESSAGE);
            out.flush();

            clientSocket.close();
        }
    }
}