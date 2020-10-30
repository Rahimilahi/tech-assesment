import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetPetByStatus {

    public static void main (String[] args){

        try {
            URL url = new URL("https://petstore.swagger.io/#/pet/findPetsByStatus");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");

            if (connection.getResponseCode() !=200){
                throw new RuntimeException("Failed: HTTP Error code: " + connection.getResponseCode());
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String output;
            System.out.println("Output from server..... \n");
            while ((output = bufferedReader.readLine())!=null){
                System.out.println(output);
            }

            connection.disconnect();

        }catch (MalformedURLException e){
            e.printStackTrace();

        }

        catch (IOException e){
            e.printStackTrace();

        }
    }
}
