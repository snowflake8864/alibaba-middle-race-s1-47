package com.alibaba.middleware.race.Tair;

import com.alibaba.middleware.race.RaceConfig;
import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.impl.DefaultTairManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 读写tair所需要的集群信息，如masterConfigServer/slaveConfigServer地址/
 * group 、namespace我们都会在正式提交代码前告知选手
 */
public class TairOperatorImpl implements Serializable {
    public static int nameSpace = RaceConfig.TairNamespace;

    private List<String> confServers = new ArrayList<String>();

    DefaultTairManager tairManager = new DefaultTairManager();
//
    public TairOperatorImpl() {
        confServers.add(RaceConfig.TairConfigServer);
        tairManager.setConfigServerList(confServers);
        tairManager.setGroupName(RaceConfig.TairGroup);
        tairManager.init();
    }

    public boolean write(Serializable key, Serializable value) {
        tairManager.put(nameSpace, key, value);
        return false;
    }

    public Object get(Serializable key) {
        Result<DataEntry> result = tairManager.get(nameSpace, key);
        if (result.isSuccess()) {
            DataEntry entry = result.getValue();
            return entry.getValue();
        } else {
            return "failed";
        }
    }

    public boolean remove(Serializable key) {
        tairManager.delete(nameSpace, key);
        return false;
    }

    public void close(){
        tairManager.close();
    }
}
