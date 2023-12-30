import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class StaticFileHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String filePath = "src/main/resources/static" + exchange.getRequestURI().getPath();
        if (filePath.endsWith("/")) {
            filePath += "index.html"; // Default to index.html
        }

        File file = new File(filePath);
        if (!file.exists()) {
            sendNotFoundResponse(exchange);
            return;
        }

        byte[] fileBytes = Files.readAllBytes(file.toPath());
        exchange.sendResponseHeaders(200, fileBytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(fileBytes);
        os.close();
    }

    private void sendNotFoundResponse(HttpExchange exchange) throws IOException {
        String response = "404 (Not Found)\n";
        exchange.sendResponseHeaders(404, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
