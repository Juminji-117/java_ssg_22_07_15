package com.ll.example;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying_ : wiseSayings) {
            if (wiseSaying_.id  == paramId) {
                return wiseSaying_;
            }
        }
        return null;
    }

    List<WiseSaying> findAll() {
        return wiseSayings;
    }

    WiseSaying create(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author); // 객체 wiseSaying
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

     void delete(int paramId) {
        WiseSaying foundWiseSaying = findById(paramId);
        wiseSayings.remove(foundWiseSaying);
    }

    void edit(int paramId, String content, String author) {
        WiseSaying foundWiseSaying = findById(paramId);
        foundWiseSaying.content = content;
        foundWiseSaying.author = author;
    }

}
