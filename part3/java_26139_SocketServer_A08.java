import java.io.*;
import java.net.*;

public class java_26139_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Waiting for a client...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read command from client
            String command = in.readUTF();

            // write response to client
            if (isIntegrityFailure(command)) {
                out.writeUTF("Integrity failure");
            } else {
                out.writeUTF("Success");
            }

            out.close();
            socket.close();
        }
    }

    private static boolean isIntegrityFailure(String command) {
        // simple check for "fail" in the command string
        return command.contains("fail");
    }
}