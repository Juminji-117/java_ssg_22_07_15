package com.ll.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    List<WiseSaying> wiseSayings = new ArrayList<>(); // WiseSayings 배열

    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);
        int lastId = 0;

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            //switch문 불편한 점: 여러 개의 초기화된 같은 의미 지역변수 생성 필요 ex.paramId, paramId_
            switch (rq.getPath()) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();

                    int id = ++lastId;
                    WiseSaying wiseSaying = new WiseSaying(id, content, author); // 객체 wiseSaying
                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (int i = 0; i < wiseSayings.size(); i++) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
                    }
                    break;
                case "삭제":
                    int paramId = rq.getIntParam("id", 0);

                    if (paramId == 0) {
                        System.out.println("id의 파라미터가 존재하지 않습니다");
                        continue;
                    }

                    WiseSaying foundWiseSaying = findById(paramId);
                    if (foundWiseSaying == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
                        continue;

                    }

                    wiseSayings.remove(foundWiseSaying);
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
            break;
                case "수정":
                    int paramId_ = rq.getIntParam("id", 0);

                    if (paramId_ == 0) {
                        System.out.println("id의 파라미터가 존재하지 않습니다");
                        continue;
                    }
                    WiseSaying foundWiseSaying_ = findById(paramId_);
                    if (foundWiseSaying_ == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId_);
                        continue;

                    }

                    System.out.printf("명언(기존) : " + foundWiseSaying_.content);
                    System.out.printf("명언 : ");
                    String content_ = sc.nextLine().trim();
                    System.out.printf("작가(기존) : " + foundWiseSaying_.author);
                    System.out.printf("작가 : ");
                    String author_ = sc.nextLine().trim();

                    foundWiseSaying_.content = content_;
                    foundWiseSaying_.author = author_;
                    System.out.printf("%d번 명언이 수정되었습니다.\n", paramId_);


                    break;
            case "종료":
                break outer;
        }
            }
        sc.close();
        }

    private WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying__ : wiseSayings) {
            if (wiseSaying__.getId()  == paramId) {
                return wiseSaying__;
            }
        }
        return null;
    }

}

