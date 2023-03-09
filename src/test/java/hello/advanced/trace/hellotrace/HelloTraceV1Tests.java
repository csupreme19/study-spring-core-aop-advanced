package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class HelloTraceV1Tests {

    @Test
    void addSpaceTest() {
        String msg = HelloTraceV2.addSpace("-->", 0);
        log.info(msg);
        msg = HelloTraceV2.addSpace("-->", 1);
        log.info(msg);
        msg = HelloTraceV2.addSpace("-->", 2);
        log.info(msg);
        msg = HelloTraceV2.addSpace("-->", 3);
        log.info(msg);
    }

    @Test
    void beginEndTest() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus traceStatus = trace.begin("hello");
        trace.end(traceStatus);
    }

    @Test
    void beginExceptionTest() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus traceStatus = trace.begin("hello");
        trace.exception(traceStatus, new IllegalArgumentException());
    }
}
