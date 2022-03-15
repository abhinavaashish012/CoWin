package Vaccine;

import com.google.gson.Gson;
import okhttp3.*;
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
        String city ="";
        String state ="";
        long vaccinesInCity = 0;
        String msg="";

        for (Centers c : centerList.getCenters())
        {
            city=c.getDistrict_name();
            state=c.getState_name();
            Sessions[] temp = c.getSessions();
            String vaccine = temp[0].getVaccine();
            long total=0;
            for(Sessions s : temp)
            {
                total+=s.getTotalVaccines();
            }
            vaccinesInCity+=total;
            msg = c.getCenter_id()+"%0A%0A"+c.getName()+"%0A%0A"+vaccine+"%0A%0A"+"Total vaccines  : "+ total+"%0A%0A";
            sendOnTelegram(msg);
        }

        System.out.println("*****************************************************************");
        String finalMsg ="Total Vaccines in " +city+"/"+state +" is : "+ vaccinesInCity;
        sendOnTelegram(finalMsg);
        System.out.println(finalMsg);
        System.out.println("*****************************************************************");
    }

    private static void sendOnTelegram(String msg) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.telegram.org/bot1763777741:AAEEh_SSjdSe0s61Rtl8KTJfPi5O62yNKVs/sendMessage?chat_id=-524951835&text="+msg)
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("Message sent....");
    }


}
/*
For multiline message in telegram use
"%0A" instead of "\n"
https://stackoverflow.com/questions/50018785/telegram-rest-api-send-newline-in-message-text
*/