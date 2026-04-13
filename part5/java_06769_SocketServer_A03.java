import java.io.*;
import java.net.*;

public class java_06769_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is running...");

        while(true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            // create streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read data from client
            String clientMsg = in.readLine();
            System.out.println("Received message: " + clientMsg);

            // send back data to client
            String serverMsg = "Message received: " + clientMsg;
            out.writeBytes(serverMsg + '\n');

            socket.close();
        }
    }
}