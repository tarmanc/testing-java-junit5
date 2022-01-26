package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Tag("owner")
class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("12345678");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName()),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity()),
                        () -> assertEquals("12345678", owner.getTelephone()))
        );
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @ParameterizedTest
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @ParameterizedTest
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 1, 1"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + ": " + val1 + " - " + val2);
    }

    @DisplayName("CSV From File Test")
    @ParameterizedTest
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + ": " + val1 + " - " + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName + ": " + val1 + " - " + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 2),
                Arguments.of("MI", 1, 1)
        );
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest
    @MethodSource("getList")
    void fromMethodBasicTest(String stateName) {
        System.out.println(stateName);
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + ": " + val1 + " - " + val2);
    }

    static Stream<String> getList() {
        return Stream.of("Ali", "Veli", "Deli");
    }
}
