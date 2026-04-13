import java.io.*;
import java.net.*;

public class java_40890_SocketServer_A08 {

    private static int portNumber = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Perform security-sensitive operations related to A08_IntegrityFailure here

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received from client: " + clientMessage);

                String serverMessage = "Server received your message successfully!";
                dataOutputStream.writeUTF(serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}