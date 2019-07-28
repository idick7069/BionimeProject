package com.example.bionimeproject.Model;

import android.content.Context;
import android.util.Log;

import com.example.bionimeproject.Network.OnDairyListener;
import com.example.bionimeproject.Network.OnStringListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class DairyQuoteModel implements IDailyQuoteModel {


    private Context context;

    private final String TAG = "DairyQuoteModel";

    public DairyQuoteModel(Context context) {
        this.context = context;
    }

    @Override
    public void getData(String url, final OnDairyListener listener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                try {
                    //由URL載入對象
                    Document doc = Jsoup.connect("https://tw.appledaily.com/index/dailyquote/").get();
                    //並選擇div.abdominis目標
                    Elements elements = doc.select("div.abdominis");
                    Log.i("abdominisTagChinese",elements.select("p").first().text());
                    Log.i("abdominisTagEnglish",elements.select("span").text());
                    Log.i("abdominisTagAnchor",elements.select("H1").first().text());
                    Log.i("abdominisTagTime",elements.select("time").text());
                    Log.i("abdominisTagSize",elements.size()+"個");

                    String engString = elements.select("span").text();
                    //去除英文部分
                    String chiString =  elements.select("p").first().text().replace(engString,"");

                    String timeString = elements.select("time").text();
                    String anchorString = elements.select("H1").text().replace(timeString,"");


                    List<String> sentences = new ArrayList<>();
                    sentences.add(chiString);
                    sentences.add(engString);
                    sentences.add(anchorString);
                    sentences.add(timeString);
                    listener.onLoadSuccess(sentences);

                }catch(Exception e) {
                    Log.e(TAG, e.toString());
                }
            }
        }.start();
    }
}
