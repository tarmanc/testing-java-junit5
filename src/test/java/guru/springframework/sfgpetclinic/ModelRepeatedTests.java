package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("modelRepeated")
public interface ModelRepeatedTests {
    @BeforeEach
    default void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {

        System.out.println("Interface --> " + testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }
}
