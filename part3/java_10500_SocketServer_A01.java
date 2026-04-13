import java.io.*;
import java.net.*;

public class java_10500_SocketServer_A01 {
    private static final String SERVER_MESSAGE = "Server Message";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started at port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Client message: " + clientMessage);

                dataOutputStream.writeUTF(SERVER_MESSAGE + ": " + clientMessage);
                dataOutputStream.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}