import java.net.*;
import java.io.*;

public class java_18785_SocketServer_A08 {
    private static int portNumber = 8080;
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected!");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");
            socket.close();
        }
    }
}