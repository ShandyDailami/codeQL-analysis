import java.io.*;
import java.net.*;

public class java_06251_SocketServer_A07 {
    private static final int port = 12345;
    private static boolean stopped = false;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while(!stopped){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                dos.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
                socket.close();
            }
            serverSocket.close();
        }catch (IOException ex){
            serverSocket.close();
            ex.printStackTrace();
        }
    }
}