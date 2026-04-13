import java.io.*;
import java.net.*;

public class java_30905_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // port 12345 is arbitrary
            while (true) {
                Socket socket = serverSocket.accept(); // waits for a connection

                // create streams for reading and writing
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // read a string from the client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // write a string back to the client
                dos.writeUTF("Message received: " + message);
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}