import java.net.*;
import java.io.*;

public class java_16881_SocketServer_A03 {
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String message = in.readLine();
            System.out.println("Client says: " + message);
            String response = processInput(message);
            out.writeBytes(response + '\n');
            out.flush();
            socket.close();
        }
    }

    private static String processInput(String input) {
        // This is a placeholder for injection.
        // For example, a sanitization process to prevent SQL injection.
        // However, in a real-world application, this would depend on the specific use case.
        return "Message processed: " + input;
    }
}