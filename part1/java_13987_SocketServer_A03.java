import java.io.*;
import java.net.*;
import java.util.*;

public class java_13987_SocketServer_A03 {
    private static final String AUTH_FILE = "auth.txt";
    private static final String PASSWORD = "secure";
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        // load auth file
        loadAuthFile();

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientName = input.readUTF();
            if (authenticate(clientName)) {
                output.writeUTF("Connection successful");
            } else {
                output.writeUTF("Connection failed, incorrect password");
           
                socket.close();
                continue;
            }

            handleData(input, output, clientName);
            socket.close();
        }
    }

    private static void loadAuthFile() {
        File file = new File(AUTH_FILE);
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] pair = line.split(":");
                users.put(pair[0], pair[1]);
            }
            scanner.close();
        }
    }

    private static boolean authenticate(String clientName) {
        return PASSWORD.equals(users.getOrDefault(clientName, ""));
    }

    private static void handleData(DataInputStream input, DataOutputStream output, String clientName) throws IOException {
        String data;
        while ((data = input.readUTF()) != null) {
            System.out.println("Received: " + data);
            output.writeUTF("Message from " + clientName + ": " + data);
        }
    }
}