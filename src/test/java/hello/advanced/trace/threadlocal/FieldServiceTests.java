package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTests {

    private FieldService fieldService = new FieldService();

    @Test
    @DisplayName("동시성 이슈 없음")
    void concurrencySuccessTest() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userB");
            }
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(2000);    // 동시성 문제 발생 X
        threadB.start();

        sleep(3000);    // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    @Test
    @DisplayName("동시성 이슈 존재")
    void concurrencyFailTest() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userB");
            }
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);    // 동시성 문제 발생
        threadB.start();

        sleep(3000);    // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
