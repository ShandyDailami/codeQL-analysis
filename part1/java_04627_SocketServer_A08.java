import java.io.*;
import java.net.*;

public class java_04627_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // listening port
        System.out.println("Server is listening on port 8080.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // read data from client
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);

            // check if the data is valid
            if (validateData(buffer, bytesRead)) {
                System.out.println("Data received is valid.");
                // send data back to client
                output.writeUTF("Data received and valid.");
            } else {
                System.out.println("Data received is not valid.");
                // send error message to client
                output.writeUTF("Data received but not valid.");
            }

            // close connection
            output.close();
            socket.close();

            System.out.println("A client has disconnected.");
        }
    }

    // simple data validation function
    private static boolean validateData(byte[] data, int length) {
        // here you can add your own logic for data validation
        // for simplicity, we just check if the length is greater than 0
        return length > 0;
    }
}