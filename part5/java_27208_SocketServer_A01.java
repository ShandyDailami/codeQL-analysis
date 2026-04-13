import java.io.*;
import java.net.*;

public class java_27208_SocketServer_A01 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is running...");

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new input stream for the client
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                // Get the message from the client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Send a response back to the client
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("Hello Client, you connected to server");
                dos.flush();
                System.out.println("Sent: Hello Client, you connected to server");

                socket.close();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}