package com.as.flypig_kotlin.application;

import java.util.ArrayList;
import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/8/26.
 * ---------------------------
 */
public class a {
    public  void xxx(){
        List<String> l=new ArrayList<String>(){
            {
                for (int i = 0; i < 20; i++) {
                    add("xx"+i);
                }

            }
        };

    }
}
