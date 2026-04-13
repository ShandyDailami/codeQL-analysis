import java.io.*;
import java.net.*;

public class java_14445_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(1234); // port
                System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();
                System.out.println("Connected to: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Client says: " + message);

                out.writeUTF("Server says: Hello, client, your data was received successfully.");
                out.flush();

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}