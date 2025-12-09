import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    // -------- checkName --------

    @Test
    void checkName_null_returnsFalse() {
        assertFalse(Utils.isValidName(null));
    }

    @Test
    void checkName_emptyString_returnsFalse() {
        assertFalse(Utils.isValidName(""));
    }

    @Test
    void checkName_nonEmptyString_returnsTrue() {
        assertTrue(Utils.isValidName("Alice"));
    }

    @Test
    void checkName_whitespaceOnly_returnsTrueAccordingToCurrentLogic() {
        // 按当前实现，只要 length() > 0 就是 true
        assertTrue(Utils.isValidName("   "));
    }

    // -------- isValidAge --------

    @Test
    void isValidAge_negative_returnsFalse() {
        assertFalse(Utils.isValidAge(-1));
    }

    @Test
    void isValidAge_zero_returnsTrue() {
        assertTrue(Utils.isValidAge(0));
    }

    @Test
    void isValidAge_normalAdult_returnsTrue() {
        assertTrue(Utils.isValidAge(30));
    }

    @Test
    void isValidAge_greaterThanUpperBound_returnsFalse() {
        // 期望“正确实现”为：年龄 > 120 应该是 false
        assertFalse(Utils.isValidAge(130));
    }
}
