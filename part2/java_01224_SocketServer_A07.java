import java.io.*;
import java.net.*;
import java.util.*;

public class java_01224_SocketServer_A07 {
    private static final int PORT = 4446;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("auth fail")) {
                output.writeUTF("auth fail");
            } else {
                output.writeUTF("auth success");
            }

            output.close();
            socket.close();
        }
    }
}