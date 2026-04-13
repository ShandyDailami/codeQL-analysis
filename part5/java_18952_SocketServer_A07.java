import java.net.*;
import java.io.*;

public class java_18952_SocketServer_A07 {
    private static final String AUTH_FAILURE_MSG = "Authentication failure";
    private static final String SERVER_MSG = "Hello Client";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6789, 5000, null, InetAddress.getByName("localhost"));
            System.out.println("Server is listening on port: " + server.getLocalPort());
            while(true) {
                Socket clientSocket = server.accept();
                System.out.println("A client connected");
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());

                String message = inputStream.readUTF();
                System.out.println("Client says: " + message);

                if (message.equals(AUTH_FAILURE_MSG)) {
                    outputStream.writeUTF(SERVER_MSG);
                    outputStream.flush();
                } else {
                    outputStream.writeUTF(AUTH_FAILURE_MSG);
                    outputStream.flush();
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}