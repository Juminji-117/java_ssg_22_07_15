// to do list
// [X] write or list 기능 오류: i번째 아이디 등록시 처음~(i-1)번째 content가 i번째 content 값으로 바뀜
package com.ll.example;

import java.util.Scanner;

public class WiseSayingController {

    private WiseSayingService wiseSayingService = new WiseSayingService();
     Scanner sc = new Scanner(System.in);

     void write() {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

        int id = ++(wiseSayingService.lastId);
         WiseSaying wiseSaying = new WiseSaying(id, content, author); // 객체 wiseSaying
         wiseSayingService.wiseSayings.add(wiseSaying);

         System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }
      void list() {
        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------------");
        for (int i = 0; i < wiseSayingService.wiseSayings.size(); i++) {
            WiseSaying wiseSaying_ = wiseSayingService.wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
        }
    }
      void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id의 파라미터가 존재하지 않습니다");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;

        }

          wiseSayingService.wiseSayings.remove(foundWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

      void modify(Rq rq) {
        int paramId_ = rq.getIntParam("id", 0);

        if (paramId_ == 0) {
            System.out.println("id의 파라미터가 존재하지 않습니다");
            return;
        }
        WiseSaying foundWiseSaying_ = wiseSayingService.findById(paramId_);
        if (foundWiseSaying_ == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId_);
            return;

        }

        System.out.printf("명언(기존) : " + foundWiseSaying_.content + "\n");
        System.out.printf("명언 : ");
        String content_ = sc.nextLine().trim();
        System.out.printf("작가(기존) : " + foundWiseSaying_.author + "\n");
        System.out.printf("작가 : ");
        String author_ = sc.nextLine().trim();

        foundWiseSaying_.content = content_;
        foundWiseSaying_.author = author_;
        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId_);


    }

}
