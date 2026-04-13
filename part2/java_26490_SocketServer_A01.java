import java.io.*;
import java.net.*;

public class java_26490_SocketServer_A01 {

    private static final String SERVER_MESSAGE = "Server: Welcome to our secure chatroom!";
    private static final String BYE_MESSAGE = "Server: Goodbye!";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                if (message.equals("bye")) {
                    out.writeUTF(BYE_MESSAGE);
                    out.flush();
                    clientSocket.close();
                    System.out.println("Client disconnected!");
                } else {
                    out.writeUTF(SERVER_MESSAGE);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}