import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08782_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected");

                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF("Connection established");

                // This is where the client-server communication can happen.
                // For now, we'll just echo back any received message.
                while (true) {
                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    out.writeUTF(message);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}