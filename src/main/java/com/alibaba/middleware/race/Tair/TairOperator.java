package com.alibaba.middleware.race.Tair;

import com.alibaba.middleware.race.RaceConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangwenfeng on 5/25/16.
 */
public class TairOperator {
    public static void main(String[] args) {

        TairOperatorImpl tairOperator = new TairOperatorImpl(RaceConfig.TairServerAddr,RaceConfig.TairNamespace);
        System.out.println("Result: "+tairOperator.get("platformTaobao_373058h4iq_1467806100"));
        System.out.println("Result: "+tairOperator.get("platformTaobao_373058h4iq_1467805920"));
        System.out.println("Result: "+tairOperator.get("platformTaobao_373058h4iq_1467805980"));
        System.out.println("Result: "+tairOperator.get("platformTaobao_373058h4iq_1467806040"));

    }

}
