package StatesAndCities;

import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;

public class StatesAndCities {
    public static void main(String[] args) throws IOException {

        String url = "https://cdn-api.co-vin.in/api/v2/admin/location/districts/16";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int respCode = con.getResponseCode();
        System.out.println("Response Code : "+ respCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine())!=null)
        {
            response.append(inputLine);
        }
        in.close();

        String ans = response.toString();
        System.out.println(ans);

        Gson gson = new Gson();

        StateDetails stateDetails = gson.fromJson(ans, StateDetails.class);

        System.out.println(stateDetails.getTtl());
        System.out.println(Arrays.toString(stateDetails.getDistricts()));

        District[] temp = stateDetails.getDistricts();


        for(District d : temp)
            System.out.println(d.getDistrict_id()+" "+d.getDistrict_name());

        System.out.println(stateDetails);
    }
}

