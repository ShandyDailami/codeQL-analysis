import java.io.*;
import java.net.*;

public class java_38714_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Simulate a delay
                Thread.sleep(2000);

                dos.writeUTF("Thank you for connecting to server");
                dos.flush();
                System.out.println("Sent: Thank you for connecting to server");

                socket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}