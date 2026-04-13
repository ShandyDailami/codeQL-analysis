import java.io.*;
import java.net.*;

public class java_17459_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server started at " + new Date());

        int connectionCount = 0;
        while (true) {
            Socket socket = serverSocket.accept();
            connectionCount++;

            System.out.println("Connection " + connectionCount + " from " + socket.getInetAddress().getHostAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Thank you for connecting to " + socket.getInetAddress().getHostAddress() + " at " + new Date());

            socket.close();
        }
    }
}