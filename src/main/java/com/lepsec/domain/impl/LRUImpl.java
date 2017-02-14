package com.lepsec.domain.impl;


import com.lepsec.domain.LRU;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jnieto on 13/2/17.
 */
public class LRUImpl implements LRU {
    private static LRUImpl ourInstance = new LRUImpl(3);
    private LinkedHashMap<Integer, String> linkedHashMap ;
    private int lruSize;

    public static LRUImpl getInstance() {
        return ourInstance;
    }

    public LRUImpl(int lruSize) {
        this.linkedHashMap = new LinkedHashMap<>();
        this.lruSize = lruSize;
    }

    public void put(int key, String value) {
        if(this.linkedHashMap.values().size() >= this.lruSize){
            this.linkedHashMap.remove(this.linkedHashMap.keySet().iterator().next());
        }
        this.linkedHashMap.put(key, value);
    }

    public String get(int key) throws Exception {

        return "";
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();

        for (String str : this.linkedHashMap.values()){
            out.append(str);
            out.append(" ");
        }
        return out.toString();
    }
}
