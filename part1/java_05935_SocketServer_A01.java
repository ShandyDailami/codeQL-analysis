import java.io.*;
import java.net.*;
import java.util.*;

public class java_05935_SocketServer_A01 {
    // main method
    public static void main(String[] args) {
        // server setup
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5555);
            System.out.println("Server started at port 5555");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // infinite loop to accept client connections
        while (true) {
            try {
                // accept client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // create input stream and output stream
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // receive message from client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // send message to client
                dos.writeUTF("Server: " + message);
                dos.flush();

                // close connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}