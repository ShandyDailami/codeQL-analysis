import java.io.*;
import java.net.*;

public class java_18231_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}