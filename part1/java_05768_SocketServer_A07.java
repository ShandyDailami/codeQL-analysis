import java.io.*;
import java.net.*;

public class java_05768_SocketServer_A07 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(54321);
            System.out.println("Waiting for client on port " +
                    serverSocket.getLocalPort() + "...");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Accepted connection from " +
                        socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String response = "Hello Client, You are Connected!";
                out.writeUTF(response);

                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("Received: " + in.readUTF());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}