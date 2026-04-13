import java.io.*;
import java.net.*;

public class java_22592_SocketServer_A03 {
    private static final int PORT = 4446;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(PORT);
                System.out.println("Server is listening on port " + PORT);
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                if (clientMessage.equals("exit")) {
                    break;
                }

                String serverMessage = "Server says: Hello " + clientMessage;
                out.writeUTF(serverMessage);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}