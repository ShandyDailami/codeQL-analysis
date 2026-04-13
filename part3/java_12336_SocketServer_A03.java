import java.io.*;
import java.net.*;

public class java_12336_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            while (true) {
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message = reader.readLine();
                System.out.println("Received: " + message);

                writer.writeBytes("Message received: " + message + "\n");
                writer.flush();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}