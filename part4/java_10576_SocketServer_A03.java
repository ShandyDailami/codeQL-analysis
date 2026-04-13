import java.io.*;
import java.net.*;
import java.util.*;

public class java_10576_SocketServer_A03 {
    private static final String COMMAND_DELIMITER = " ";
    private static final String ERROR_MESSAGE = "Error: Incorrect command. Use the command 'help' for a list of commands.";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String commandLine;
            while ((commandLine = in.readLine()) != null) {
                handleCommand(commandLine, out);
            }

            socket.close();
        }
    }

    private static void handleCommand(String commandLine, PrintWriter out) {
        String[] parts = commandLine.split(COMMAND_DELIMITER);
        if (parts.length == 1) {
            switch (parts[0]) {
                case "help":
                    out.println("Commands: help, exit");
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    out.println(ERROR_MESSAGE);
                    break;
            }
        } else {
            out.println(ERROR_MESSAGE);
        }
    }
}