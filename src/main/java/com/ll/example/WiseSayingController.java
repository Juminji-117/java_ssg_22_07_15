/*
write or list 기능 오류 해결: i번째 아이디 등록시 처음~(i-1)번째 content가 i번째 content 값으로 바뀜
->원인:WiseSaying 클래스에서 content가 static 처리되어 있었음
 */
package com.ll.example;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private WiseSayingService wiseSayingService = new WiseSayingService();
    private Scanner sc = new Scanner(System.in);

     void create() {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingService.create(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);
    }

      void list() {
          System.out.println("번호 / 명언 / 작가");
          System.out.println("----------------------");

          List<WiseSaying> wiseSayings = wiseSayingService.findAll();

          for (int i = 0; i < wiseSayings.size(); i++) {
              WiseSaying wiseSaying_ = wiseSayings.get(i);
              System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
          }
    }

      void delete(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id의 파라미터가 존재하지 않습니다");
        }

        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
        }

        wiseSayingService.delete(paramId);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

      void edit(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id의 파라미터가 존재하지 않습니다");
        }

        WiseSaying foundWiseSaying_ = wiseSayingService.findById(paramId);
        if (foundWiseSaying_ == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
        }

        System.out.printf("명언(기존) : " + foundWiseSaying_.content + "\n");
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가(기존) : " + foundWiseSaying_.author + "\n");
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

        wiseSayingService.edit(paramId,content,author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);
    }

}
