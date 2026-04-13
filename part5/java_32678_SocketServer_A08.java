import java.io.*;
import java.net.*;

public class java_32678_SocketServer_A08 {
    private static final String HANDSHAKE_MESSAGE = "Client is authenticated";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client is connected");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage = reader.readLine();
                System.out.println("Received client message: " + clientMessage);

                if (clientMessage.equals(HANDSHAKE_MESSAGE)) {
                    writer.writeBytes("Server accepted the client's handshake\n");
                } else {
                    writer.writeBytes("Client handshake failed\n");
               
                }

                writer.flush();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}