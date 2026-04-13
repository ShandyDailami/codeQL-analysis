import java.io.*;
import java.net.*;

public class java_23365_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received from client: " + clientMessage);

            if (clientMessage.equals("A08_IntegrityFailure")) {
                System.out.println("Encountered A08_IntegrityFailure, sending response back...");
                String response = "Success";
                dataOutputStream.writeUTF(response);
            } else {
                System.out.println("No A08_IntegrityFailure detected. Sending response back to client...");
                String response = "Failure";
                dataOutputStream.writeUTF(response);
            }

            dataOutputStream.close();
            socket.close();
        }
    }
}