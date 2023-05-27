package com.nha1400.project02;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nha1400.project02.model.ParkInfo;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Tab2Fragment extends Fragment {
    RecyclerView recyclerView;
    ParkAdapter parkAdapter;

    ArrayList<ParkInfo> parkInfos =new ArrayList<>();
    //HashMap<String, Integer> parkPic = new HashMap();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_tab2_fragment,container,false);
        recyclerView = view.findViewById(R.id.recyclerview_item);
        parkAdapter = new ParkAdapter(getActivity(), parkInfos);
        recyclerView.setAdapter(parkAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clickBtn();
    }


    void clickBtn() {
        new Thread() {
            @Override
            public void run() {
                String url = "https://openapi.gg.go.kr/OTHERHALFANIENTPARK?Key=cd09a6cf56da4f89b6179967aab71a7c&Type=xml&pIndex=&pSize=100";

                try {
                    URL url1 = new URL(url);
                    InputStream is = url1.openStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp = factory.newPullParser();
                    xpp.setInput(isr);

                    int eventType = xpp.getEventType();
                    ParkInfo parkInfo = null;

                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        switch (eventType) {
                            case XmlPullParser.START_DOCUMENT:
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(), "찾는중.. ", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;

                            // case XmlPullParser.END_DOCUMENT: break;

                            case XmlPullParser.START_TAG:
                                String tagname = xpp.getName();
                                if (tagname.equals("row")) {
                                    parkInfo = new ParkInfo();
                                } else if (tagname.equals("PARK_NM")) {
                                    xpp.next();
                                    parkInfo.name = xpp.getText();
                                } else if (tagname.equals("SIGNGU_NM")) {
                                    xpp.next();
                                    parkInfo.addr = xpp.getText();
                                } else if (tagname.equals("IMAGE_NM")){
                                    xpp.next();
                                    // 이미지 이름
                                    String imageName = ("p" + xpp.getText());
                                    //확장자를 제거하기 위해 split
                                    String[] img = imageName.split("\\.");
                                    //img[0]만 필요하므로 0번 배열만 사용.
                                    int resId = getResources().getIdentifier(img[0],"drawable",getContext().getPackageName());
                                    Log.i("resId", String.valueOf(resId));
                                    parkInfo.image = resId;
                                }
                                break;

                            case XmlPullParser.END_TAG:
                                String tagName2 = xpp.getName();
                                if (tagName2.equals("row")) {
                                    parkInfos.add(parkInfo);
                                }
                                break;

                        }
                        eventType = xpp.next();
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            parkAdapter.notifyDataSetChanged();
                        }
                    });


                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (XmlPullParserException e) {
                    throw new RuntimeException(e);
                }


            }
        }.start();
    }
}