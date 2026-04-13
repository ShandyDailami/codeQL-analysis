import java.io.*;
import java.net.*;

public class java_35173_SocketServer_A07 {
    private static boolean stop = false;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
            System.out.println("Server is listening at port 5000");

            while (!stop) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Client says: " + message);

                String response = "Hello Client, Welcome to Vanilla Java Server!";
                dos.writeUTF(response);
                System.out.println("Server says: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}