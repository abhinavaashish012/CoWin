import requests
import datetime
import time

dist_id=97
numdays=7
base = datetime.date.today()
date_list = [base + datetime.timedelta(days=x+1) for x in range(numdays)]
date_str = [x.strftime("%d-%m-%Y") for x in date_list]
chat_id="1763777741:AAEEh_SSjdSe0s61Rtl8KTJfPi5O62yNKVs"
try:
    while(1):
        print(f"Script running at {datetime.datetime.now()}")
        print("##############################################")
        for date in date_str:
            get_by_district=f"https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id={dist_id}&date={date}"
            payload={}
            headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36'}
            r = requests.get(get_by_district, headers=headers)
            #print(type(r.json()))
            d=r.json()
            if r.status_code == 200:
                for i in range (0,len(d['centers'])):
                    #print(f"Center number : {i} --- {d['centers'][i]['name']} --- {d['centers'][i]['pincode']}") #working display
                    for j in range(0,len(d['centers'][i]['sessions'])):
                        #print(f"{d['centers'][i]['sessions'][j]}")   #working display
                        if d['centers'][i]['sessions'][j]['min_age_limit'] ==18 and d['centers'][i]['sessions'][j]['available_capacity_dose1'] >0:
                            vaccine =d['centers'][i]['sessions'][j]['vaccine']
                            center=d['centers'][i]['name']
                            date_vacc=date
                            dose1=d['centers'][i]['sessions'][j]['available_capacity_dose1']
                            dose2=d['centers'][i]['sessions'][j]['available_capacity_dose2']
                            Link = " https://selfregistration.cowin.gov.in"
                            m= f"Vaccine : {vaccine} \n\nCenter : {center} \n\nDate : {date_vacc}\n\n Dose1 : {dose1} \n\n Dose2 : {dose2} \n\n Link : {Link}\n\n"
                            #m=f"{d['centers'][i]['name']}======={d['centers'][i]['sessions'][j]['vaccine']}\n\n Age :{d['centers'][i]['sessions'][j]['min_age_limit']} \n\nDate : {date} \n\n Link :\n https://selfregistration.cowin.gov.in"
                            telegram_msg=f"https://api.telegram.org/bot{chat_id}/sendMessage?chat_id=-524951835&text={m}"
                            print(m)
                            requests.get(telegram_msg)
            time.sleep(5)
except Exception as e:
    telegram_msg=f"https://api.telegram.org/bot1763777741:AAEEh_SSjdSe0s61Rtl8KTJfPi5O62yNKVs/sendMessage?chat_id=-524951835&text={e}"
    requests.get(telegram_msg)
