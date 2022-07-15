package com.ll.example;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
     List<WiseSaying> wiseSayings = new ArrayList<>(); // WiseSayings 배열
    static int lastId = 0;

     WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying__ : wiseSayings) {
            if (wiseSaying__.getId()  == paramId) {
                return wiseSaying__;
            }
        }
        return null;
    }

}
