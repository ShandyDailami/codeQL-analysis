import java.io.*;
import java.net.*;

public class java_41566_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6789);
            System.out.println("Server started on port 6789");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Read from client
                String clientMessage = dataInputStream.readUTF();
                System.out.println("Client says: " + clientMessage);

                // Echo back to client
                dataOutputStream.writeUTF(clientMessage);
                dataOutputStream.flush();
                System.out.println("Server says: " + clientMessage);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}