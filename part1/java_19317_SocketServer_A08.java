import java.io.*;
import java.net.*;

public class java_19317_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                if (clientMessage.equals("bye")) {
                    out.writeUTF("bye from server");
                    out.flush();
                    System.out.println("Client disconnected");
                    socket.close();
                } else {
                    out.writeUTF("hello from server");
                    out.flush();
               
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}