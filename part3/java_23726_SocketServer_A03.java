import java.io.*;
import java.net.*;

public class java_23726_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started at port 5000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientMessage = reader.readLine();
            System.out.println("Client message: " + clientMessage);

            String serverMessage = processInput(clientMessage);
            writer.write(serverMessage.getBytes());

            socket.close();
        }
    }

    private static String processInput(String input) {
        // TODO: Add your security-sensitive operations related to A03_Injection here
        // For example, perform a SQL injection attack by adding an additional parameter to the SQL query
        // Return a placeholder for now
        return "Server message: " + input;
    }
}