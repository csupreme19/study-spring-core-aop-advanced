package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTests {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void beginEndTest() {
        TraceStatus status1 = trace.begin("status1");
        TraceStatus status2 = trace.begin("status2");
        TraceStatus status3 = trace.begin("status3");
        trace.end(status3);
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void beginExceptionTest() {
        TraceStatus status1 = trace.begin("status1");
        TraceStatus status2 = trace.begin("status2");
        TraceStatus status3 = trace.begin("status3");
        Exception e = new IllegalArgumentException();
        trace.exception(status3, e);
        trace.exception(status2, e);
        trace.exception(status1, e);
    }
}