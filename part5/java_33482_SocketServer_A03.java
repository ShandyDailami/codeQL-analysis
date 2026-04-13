import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_33482_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Create a socket and bind it to a port.
            Socket socket = new Socket("localhost", 1234);

            // Create input and output streams.
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle user input.
            out.println("Enter your message:");
            String userInput = in.readLine();

            // Construct and execute SQL command.
            String sqlCommand = "SELECT * FROM Users WHERE Name = '" + userInput + "'";
            out.println(sqlCommand);

            // Read server's response.
            String response = in.readLine();
            System.out.println("Server's response: " + response);

            // Close the connection.
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}