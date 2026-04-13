import java.io.*;
import java.net.*;
import java.util.*;

public class java_17885_SocketServer_A08 {
    private static final int PORT = 4445;
    private static boolean running = true;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while(running){
            Socket socket = server.accept();
            handle(socket);
        }
        server.close();
    }

    private static void handle(Socket socket) {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Server: Hello, Client!";
            dos.writeUTF(serverMessage);
            dos.flush();

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}