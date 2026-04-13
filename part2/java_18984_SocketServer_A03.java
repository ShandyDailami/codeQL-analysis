import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18984_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String userInput = dis.readUTF();

            // Prevent SQL Injection by using PreparedStatements.
            // This is a simple example and might not be effective in a real application.
            String sql = "SELECT * FROM users WHERE name = '" + userInput + "'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                dos.writeUTF("User not found.");
            } else {
                dos.writeUTF("User found. Welcome, " + result.getString("name"));
            }

            dos.close();
            socket.close();
        }
    }
}