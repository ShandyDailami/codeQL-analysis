import java.io.*;
import java.net.*;

public class java_04456_SocketServer_A01 {
    private static final String SERVER_MESSAGE = "hello";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                if (clientMessage.equals(SERVER_MESSAGE)) {
                    out.writeUTF("Server says: Hello, Client!");
                    out.flush();
                } else {
                    out.writeUTF("Server says: Wrong message, Client!");
                    out.flush();
               
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}