import java.io.*;
import java.net.*;
import java.util.*;

public class java_14531_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientMsg;
            while ((clientMsg = reader.readLine()) != null) {
                System.out.println("Received: " + clientMsg);

                // Broken access control: Attempt to execute code with clientMsg
                // This is a basic attack, do not use in a real-world scenario
                try {
                    // Execute arbitrary command
                    Runtime.getRuntime().exec(clientMsg);
                } catch (Exception e) {
                    System.out.println("Execution failed: " + e.getMessage());
                }

                // Send back a response
                writer.writeBytes("Server response: Handled by client. \n");
                writer.flush();
            }

            socket.close();
        }
    }
}