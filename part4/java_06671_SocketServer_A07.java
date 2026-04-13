import java.io.*;
import java.net.*;

public class java_06671_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        while (true) {
            Socket socket = serverSocket.accept();
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            // Authentication logic
            String user = (String) inputStream.readObject();
            if (authenticate(user)) {
                outputStream.writeObject("Success");
            } else {
                outputStream.writeObject("Failure");
            }

            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    // Assume we have a method to authenticate a user.
    private static boolean authenticate(String user) {
        // Add your own authentication logic here.
        // For simplicity, we're just checking if the user is "admin".
        return user.equals("admin");
    }

}