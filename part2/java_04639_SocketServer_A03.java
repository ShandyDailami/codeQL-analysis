import java.net.*;
import java.io.*;

public class java_04639_SocketServer_A03 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Simple injection protection. Replace 'bad_command' with a harmful command.
            String badCommand = "bad_command";
            String safeCommand = "command - " + message;

            out.writeUTF(safeCommand);
            out.flush();

            socket.close();
        }
    }
}