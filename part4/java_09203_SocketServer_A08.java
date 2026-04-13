import java.io.*;
import java.net.*;

public class java_09203_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String command = in.readUTF();
            if (command.equals("A08_IntegrityFailure")) {
                out.writeUTF("Security failure");
            } else {
                out.writeUTF("Correct command");
            }

            clientSocket.close();
        }
    }
}