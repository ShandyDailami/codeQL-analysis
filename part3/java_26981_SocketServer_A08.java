import java.io.*;
import java.net.*;

public class java_26981_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                break;
            }

            out.writeUTF("Message received successfully");
            out.flush();

            socket.close();
       
        }

        serverSocket.close();
    }
}