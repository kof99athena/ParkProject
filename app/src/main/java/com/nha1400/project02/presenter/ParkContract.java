package com.nha1400.project02.presenter;

public interface ParkContract {

    //1. view라면 가져야하는 인터페이스 2개
            interface splash{
                void splashStart();
                //스플래쉬 화면을 띄우는 메소드
            }

            interface main{
                void mainStart();
            }

            interface openApi{
                void clickBtn();
            }

    //2. presenter라면 가져야할 인터페이스 1개



}
