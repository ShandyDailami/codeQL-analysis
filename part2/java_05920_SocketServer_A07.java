import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_05920_SocketServer_A07 {
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(65000);
            System.out.println("Server started");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF();
                if (clientMessage.startsWith("REGISTER")) {
                    String[] data = clientMessage.split(":");
                    if (users.containsKey(data[1])) {
                        dos.writeUTF("FAIL:User already exists");
                    } else {
                        users.put(data[1], data[2]);
                        dos.writeUTF("SUCCESS:User registered");
                    }
                } else if (clientMessage.startsWith("LOGIN")) {
                    String[] data = clientMessage.split(":");
                    if (!users.containsKey(data[1]) || !users.get(data[1]).equals(data[2])) {
                        dos.writeUTF("FAIL:Invalid username or password");
                    } else {
                        dos.writeUTF("SUCCESS:Logged in");
                    }
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}