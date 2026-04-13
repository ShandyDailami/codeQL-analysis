import java.io.*;
import java.net.*;

public class java_20730_SocketServer_A08 {
    private static final String SERVER_NAME = "VanillaServer";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println(SERVER_NAME + " is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted a new connection from " + clientSocket.getRemoteSocketAddress());

                DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

                String clientInput = dataIn.readUTF();
                System.out.println("Received: " + clientInput);

                String response = "Echo: " + clientInput;
                dataOut.writeUTF(response);
                System.out.println("Sent: " + response);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}