import java.io.*;
import java.net.*;

public class java_28590_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive file name from client
            String fileName = in.readLine();
            System.out.println("Received file name: " + fileName);

            // Send integrity check
            out.writeBytes("Checking integrity of " + fileName + "...\n");

            // Assume integrity check is successful
            out.writeBytes("Integrity check successful\n");

            // Close the connection
            out.close();
            socket.close();
        }
    }
}