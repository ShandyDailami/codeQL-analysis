import java.io.*;
import java.net.*;

public class java_24113_SocketServer_A08 {

    private static final String QUIT_COMMAND = "/quit";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            System.out.println("Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String command;
            while ((command = in.readUTF()) != null) {
                if (command.equals(QUIT_COMMAND)) {
                    out.writeUTF("Connection closed");
                    System.out.println("Connection closed!");
                    break;
                } else {
                    // Some security-sensitive operation related to A08_IntegrityFailure.
                    // The operation is intentionally left as a placeholder.
                    out.writeUTF("Command received: " + command);
                }

                out.flush();
            }

            clientSocket.close();
        }
    }
}