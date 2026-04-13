import java.io.*;
import java.net.*;
import java.nio.file.*;

public class java_37936_SocketServer_A03 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 8080;
    private static final String DIRECTORY = "files";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String fileName = in.readLine();
            if (fileName == null) {
                continue;
            }

            File file = new File(DIRECTORY, fileName);
            if (!file.exists()) {
                out.writeBytes("File not found\n");
                continue;
            }

            out.writeBytes("HTTP/1.1 200 OK\n\n");
            serverFile(out, file);
        }
    }

    private static void serverFile(DataOutputStream out, File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        out.writeBytes(reader.readLine() + "\n");

        while ((fileName = reader.readLine()) != null) {
            out.writeBytes(fileName + "\n");
        }

        reader.close();
    }
}