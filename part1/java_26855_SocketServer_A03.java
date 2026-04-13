import java.net.*;
import java.io.*;

public class java_26855_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Set up the server socket
        ServerSocket serverSocket = new ServerSocket(4444);

        while (true) {
            // Listen for a new client
            Socket clientSocket = serverSocket.accept();

            // Set up input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            // Echo the client's message back to them
            while ((inputLine = in.readLine()) != null) {
                out.println("Echo: " + commandInjection(inputLine)); // This is a simple command injection example
            }

            // Close the connection
            clientSocket.close();
        }
    }

    // This is a very basic command injection example. In real-world scenarios,
    // you would probably use a more robust method to construct and execute the command.
    public static String commandInjection(String input) {
        try {
            String command = "cmd.exe /c " + input;
            Process process = Runtime.getRuntime().exec(command);

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String response = "";
            while ((line = reader.readLine()) != null) {
                response += line;
            }
            reader.close();

            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}