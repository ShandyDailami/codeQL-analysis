import java.io.*;
import java.net.*;
import java.util.*;

public class java_27901_SocketServer_A08 {
    private static String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "... ");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        String message = in.readUTF();
        if (message.equals(CLIENT_IDENTIFIER)) {
            out.writeUTF("SERVER_IDENTIFIER");
        } else {
            out.writeUTF("INCORRECT_IDENTIFIER");
        }

        clientSocket.close();
    }
}