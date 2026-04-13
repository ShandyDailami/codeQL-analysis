import java.io.*;
import java.net.*;
import java.util.*;

public class java_23874_SocketServer_A03 {
    private static List<String> database = Arrays.asList("John", "Jane", "Doe");

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            while (true) {
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientName = in.readUTF();
                String query = in.readUTF();

                if (isValid(clientName) && isValid(query)) {
                    out.writeUTF("Valid name and query");
                } else {
                    out.writeUTF("Invalid name or query");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(String value) {
        for (String word : database) {
            if (word.equals(value)) {
                return true;
            }
        }
        return false;
    }
}