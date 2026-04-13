import java.io.*;
import java.net.*;

public class java_28891_SocketServer_A08 {
    private static final String CLIENT_ID = "1234567890"; // this should be a unique identifier for the client

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted from: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientID = in.readUTF();

                if (!clientID.equals(CLIENT_ID)) {
                    System.out.println("Client ID does not match, closing connection");
                    socket.close();
                    continue;
                }

                out.writeUTF("Successfully authenticated");
                out.flush();
                System.out.println("Successfully authenticated the client");
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}