import java.io.*;
import java.net.*;

public class java_03657_SocketServer_A07 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server Started...");

            while (true) {
                socket = serverSocket.accept();

                System.out.println("Client Connected : " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Client says : " + message);

                String response = "Hello Client, You are connected to Server!";
                out.writeUTF(response);
                System.out.println("Server says : " + response);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}