package com.nha1400.project02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class Tab1Fragment extends Fragment {

//    MapView mapView=null; //지도를 보여주는 Mapview를 가져오자
//
//
//    @Nullable
//    @Override
//    //Fragment를 상속받으면 반드시 구현해야하는 메소드 : onCreateView
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_tab1_fragment, container, false);
//    }
//
//        new MapView(getActivity());
//        ViewGroup containerMapView=view.findViewById(R.id.container_mapview);
//        containerMapView.addView(mapView);
//
//        //5. 가이드문서에 지도를 다루는 코드들이 모두소개되어있다.
//        // 중심점 변경
//        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
//
//        // 줌 레벨 변경
//        mapView.setZoomLevel(7, true);
//
//        // 중심점 변경 + 줌 레벨 변경
//        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.5617, 127.0343), 3, true);
//
//        // 줌 인
//        mapView.zoomIn(true);
//
//        // 줌 아웃
//        mapView.zoomOut(true);
//
//        //마커표시하기 [카카오에서는 POI로 얘기함]
//        MapPOIItem marker=new MapPOIItem();
//        marker.setItemName("나의 마커");
//        marker.setTag(0);
//        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(37.5617, 127.0343)); //MapPoint는 Location같은놈, 위도 경도를 알려주는 카카오만의 클래스
//        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
//        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
//
//        mapView.addPOIItem(marker);
//
//        return view;
//    }
}