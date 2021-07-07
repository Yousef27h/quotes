package quotes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuoteAPI {
    public void readApi() throws IOException {
        String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        // create connection with url
        HttpURLConnection connection = (HttpURLConnection)  new URL(url).openConnection();
        // set time outs
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        // check whether api is good
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // read data from api
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();
            bufferedReader.close();
            // convert JSON into object
            Gson gson = new Gson();
            DeserializeAPI user = gson.fromJson(data,DeserializeAPI.class);
            System.out.println("Random quote from API: "+user.quoteText);
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            FileWriter fileWriter = new FileWriter("test.json");
            apiWrite apiWrite = new apiWrite(user.quoteText);
            gson.toJson(apiWrite.toString(), fileWriter);
            fileWriter.close();
//            if (reader!=null){
//                BufferedWriter writer = new BufferedWriter(new FileWriter("test.json", true));
//                writer.append(String.valueOf(reader));
//                writer.close();
//            }else{
//                BufferedWriter writer = new BufferedWriter(new FileWriter("test.json"));
//                writer.write(data);
//                writer.close();
//            }
        }

    }
}
