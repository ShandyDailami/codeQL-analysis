import java.io.*;
import java.net.*;

public class java_35475_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getInetAddress().getHostAddress());
                out.flush();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}