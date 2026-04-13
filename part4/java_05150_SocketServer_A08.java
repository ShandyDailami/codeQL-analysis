import java.io.*;
import java.net.*;

public class java_05150_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for a client...");
            Socket socket = server.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    out.writeBytes("Thank you for connecting\n");
                    socket.close();
                    server.close();
                } else {
                    out.writeBytes("Thank you for connecting\n");
                }
            }
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}