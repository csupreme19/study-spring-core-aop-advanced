package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관하는 형식
 */
@Slf4j
public class ContextV1 {

    // 변하는 부분
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    // 변하지 않는 부분
    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call();    // 위임
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime: {}ms", resultTime);
    }

}
