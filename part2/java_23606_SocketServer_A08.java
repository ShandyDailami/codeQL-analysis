import java.io.*;
import java.net.*;

public class java_23606_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected");

                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String message = in.readLine();
                System.out.println("Received message: " + message);

                // Here we are only simulating a successful integrity check by comparing message length
                if (message.length() > 10) {
                    System.out.println("Integrity check failed, closing connection");
                    client.close();
                } else {
                    System.out.println("Integrity check passed, sending response");
                    out.writeBytes("Message received\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}