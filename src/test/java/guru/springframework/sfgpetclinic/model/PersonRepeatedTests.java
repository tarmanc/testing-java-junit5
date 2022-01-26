package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTests implements ModelRepeatedTests {
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {

    }

    @RepeatedTest(value = 5, name = "{displayName}")
    @DisplayName("Armanc")
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 10, name = "Armanç --> " + RepeatedTest.DISPLAY_NAME_PLACEHOLDER + ": "
            + RepeatedTest.CURRENT_REPETITION_PLACEHOLDER + " of " + RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
    @DisplayName("Assignment Test")
    void assignment() {
    }
}
