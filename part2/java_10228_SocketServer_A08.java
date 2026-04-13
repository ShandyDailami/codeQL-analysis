import java.io.*;
import java.net.*;

public class java_10228_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            // Check if the message is 'exit' to close the connection
            if (message.equals("exit")) {
                dos.writeUTF("Connection closed");
                socket.close();
                System.out.println("Connection closed");
                continue;
            }

            // Check if the message is a valid command
            if (message.startsWith("command:")) {
                String command = message.split(":")[1];

                // Check if the command is 'send-file'
                if (command.equals("send-file")) {
                    String fileName = command.split(":")[1];
                    String filePath = "/path/to/files/" + fileName;

                    File file = new File(filePath);
                    dos.writeUTF("File path: " + filePath);

                    // Check if the file exists
                    if (file.exists()) {
                        dos.writeUTF("File exists");
                    } else {
                        dos.writeUTF("File does not exist");
                   
                        // Send an error message
                        dos.writeUTF("Error: File not found");
                    }
                } else {
                    // Send an error message
                    dos.writeUTF("Error: Unknown command");
                }
            } else {
                // Send an error message
                dos.writeUTF("Error: Unknown command");
            }

            dos.flush();
        }
    }
}