package vhrybyniuk.web.server;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ResponseWriter {
    public String SendRepsonse(String content, BufferedWriter writer) {
        try {
            writer.write("HTTP/1.1 200 OK \n");
            writer.newLine();


            File file = new File(content);
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] bWrite = new byte[(int)file.length()];

            while ((fileInputStream.read(bWrite)) > 0) {
                String s = new String(bWrite, StandardCharsets.UTF_8);
                writer.write(s);
            }
        }catch (IOException ex){

            return "404";
        }

        return "200";
    }
}
