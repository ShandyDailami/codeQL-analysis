import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class java_29874_SocketServer_A07 {

    private static final String AUTH_USER = "test";
    private static final String AUTH_PASS = "test";

    private static Map<String, String> users = new HashMap<String, String>();

    static {
        users.put("test", "test");
    }

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(6666);
            System.out.println("Server started.");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected.");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Received: " + clientMessage);

                String authMessage = clientMessage.split(" ")[0];
                String user = clientMessage.split(" ")[1];
                String pass = clientMessage.split(" ")[2];

                if (authMessage.equals("auth") &&
                    users.get(user).equals(pass)) {
                    out.writeUTF("Welcome " + user);
                    out.flush();
                } else {
                    out.writeUTF("auth failed");
                    out.flush();
                    socket.close();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}