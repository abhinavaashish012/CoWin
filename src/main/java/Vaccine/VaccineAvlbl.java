package Vaccine;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class VaccineAvlbl {
    public static void main(String[] args) throws Exception {

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        int dist_id =97;
        String vacByDistrictandDate = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id="+ dist_id +"&date=" +date;
        System.out.println(vacByDistrictandDate);
        URL obj = new URL(vacByDistrictandDate);
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
        //System.out.println(ans);

        Gson gson = new Gson();

        CenterList centerList = gson.fromJson(ans, CenterList.class);

        //System.out.println(centerList);
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        for (Centers c : centerList.getCenters())
        {
            System.out.println(c.getCenter_id()+" "+c.getName());
        }



    }
}
