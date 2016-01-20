package com.demo.hqinterviewdemo.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.demo.hqinterviewdemo.R;
import com.demo.hqinterviewdemo.adapters.ListAdapter;
import com.demo.hqinterviewdemo.model.DataBean;
import com.demo.hqinterviewdemo.model.DataBeanList;
import com.demo.hqinterviewdemo.utils.Alert;
import com.demo.hqinterviewdemo.utils.InternetCheckUtils;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private Context context;
    private DataBeanList dataBeanList;
    private ListView listView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        context = this;
//        callService();


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = (ListView) findViewById(R.id.listview);

        if(InternetCheckUtils.isOnline(context)){

            callServiceUsingVolley();
        }else{
            progressBar.setVisibility(View.GONE);
//            Toast.makeText(context, "Please check the internet connection!", Toast.LENGTH_SHORT).show();
            Alert.pop_Alert(context, "Please Check The Intenet Connectivity!");
        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("DataBean", dataBeanList.getDataBean(position));
                startActivity(intent);
            }
        });

    }


    private void callServiceUsingVolley(){

        String url = "http://appcontent.hotelquickly.com/en/1/android/index.json";

        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonResponse = new JSONObject(response);
                            ArrayList<String> dataList = new ArrayList<>();
                            dataList.add("base");
                            dataList.add("bestPrice");
                            dataList.add("cannotRedeem");
                            dataList.add("cityCoverage");
                            dataList.add("cityPromotion");
                            dataList.add("cityUnknown");
                            dataList.add("creditsEmpty");
                            dataList.add("creditsList");
                            dataList.add("creditsListExpired");
                            dataList.add("creditsListUsed");
                            dataList.add("creditsOverview");
                            dataList.add("discount");
                            dataList.add("faq");
                            dataList.add("forcedRegistration");
                            dataList.add("forHotels");
                            dataList.add("guestInfoRequired");
                            dataList.add("hotelquickly");
                            dataList.add("howDoesItWork");
                            dataList.add("howToShare");
                            dataList.add("index");
                            dataList.add("jobs");
                            dataList.add("lineDemo");
                            dataList.add("locationUnknown");
                            dataList.add("loyaltyProgram");
                            dataList.add("news");
                            dataList.add("noCreditForOrder");
                            dataList.add("notificationList");
                            dataList.add("offerInfo");
                            dataList.add("offerReviews");
                            dataList.add("orderCalculation");
                            dataList.add("ordersSavings");
                            dataList.add("pointsOfInterest");
                            dataList.add("policy");
                            dataList.add("priceGuaranteeDetail");
                            dataList.add("priceGuaranteeOverview");
                            dataList.add("roomsinfo");
                            dataList.add("roomsOfferInfo");
                            dataList.add("securityInfo");
                            dataList.add("shaking");
                            dataList.add("sharingContacts");
                            dataList.add("sharingDetails");
                            dataList.add("sharingOverview");
                            dataList.add("soldOut");
                            dataList.add("support");
                            dataList.add("terms");
                            dataList.add("termsReferrals");
                            dataList.add("whySoFew");

                            dataBeanList = new DataBeanList();

                            for(int i = 0; i< dataList.size(); i++){
                                getDataFromJson(jsonResponse, dataList.get(i).toString());

                            }
                            progressBar.setVisibility(View.GONE);
                            ListAdapter adapter = new ListAdapter(context, dataBeanList);
                            listView.setAdapter(adapter);

                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("HGInterviewDemo", "Error while parsing", e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Log.e("HGInterviewDemo", "Error while calling service using volley", error);
                    }
                }
        ) {
        };
        Volley.newRequestQueue(this).add(postRequest);
    }

    private void getDataFromJson(JSONObject jsonResponse, String objName){
        try {
            JSONObject jObj = jsonResponse.getJSONObject(objName);
            DataBean dataBean = new DataBean();
            dataBean.setUrl(jObj.getString("url"));
            dataBean.setFilePath(jObj.getString("filePath"));
            dataBean.setNamespace(jObj.getString("namespace"));
            dataBean.setCache(jObj.getBoolean("cache"));
            dataBean.setKey(objName);

            dataBeanList.addDataBean(dataBean);

        }catch (Exception e){
            e.printStackTrace();
            Log.e("HGInterviewDemo", "Error while insert data to bean", e);
        }
    }
}
