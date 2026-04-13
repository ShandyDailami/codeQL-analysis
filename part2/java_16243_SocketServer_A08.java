import java.io.*;
import java.net.*;

public class java_16243_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while(true) {
                socket = serverSocket.accept();
                System.out.println("A client has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Client says: " + message);

                message = "Message received, processed and sent back";
                out.writeUTF(message);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}