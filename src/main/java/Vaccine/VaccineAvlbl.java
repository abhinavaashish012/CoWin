package Vaccine;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VaccineAvlbl {
    public static void main(String[] args) throws Exception {

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        int dist_id =97;
        String vaccineByDistrictAndDate = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id="+ dist_id +"&date=" +date;
        System.out.println(vaccineByDistrictAndDate);
        URL obj = new URL(vaccineByDistrictAndDate);
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
        Gson gson = new Gson();
        CenterList centerList = gson.fromJson(ans, CenterList.class);
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        String city ="";
        String state ="";
        long vaccinesInCity = 0;
        for (Centers c : centerList.getCenters())
        {
            city=c.getDistrict_name();
            state=c.getState_name();
            Sessions[] temp = c.getSessions();
            String vaccine = temp[0].getVaccine();
            System.out.println(c.getCenter_id()+" "+c.getName()+" "+vaccine);
            long total=0;
            for(Sessions s : temp)
            {
                total+=s.getTotalVaccines();
            }
            vaccinesInCity+=total;
            System.out.println("Total vaccines  : "+ total);
            System.out.println(".......................................");
        }

        System.out.println("*****************************************************************");
        System.out.println("Total Vaccines in " +city+"/"+state +" is : "+ vaccinesInCity);
        System.out.println("*****************************************************************");
    }


}
