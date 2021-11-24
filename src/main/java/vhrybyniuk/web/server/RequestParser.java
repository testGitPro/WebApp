package vhrybyniuk.web.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestParser {

    public Request parseRequest(BufferedReader reader) throws IOException {
        String URI = null;
        Request request = new Request();
        String uriAndMethod = reader.readLine();

        String[] firstLineArray = uriAndMethod.split("\\s");
        request.setMethod(HttpMethod.valueOf(firstLineArray[0].trim()));
        request.setUri(firstLineArray[1].trim());

        Map<String, String> headersMap = new HashMap<>();

        while (true){
            String head = reader.readLine();


            if(head.equals("")){
                break;
            }

            String[] divideBy = head.split(":\\s");
            headersMap.put(divideBy[0], divideBy[1]);

        }

        request.setHeaders(headersMap);

            if(request.getMethod().equals(HttpMethod.GET)){
                request.setMethod(HttpMethod.GET);
            }else if(request.getMethod().equals(HttpMethod.POST)){
                request.setMethod(HttpMethod.POST);
            }

        return request;
    }

}
