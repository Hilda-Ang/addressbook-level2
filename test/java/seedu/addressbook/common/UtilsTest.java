package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, Integer.valueOf(1));
        assertNotUnique(null, 1, Integer.valueOf(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);

        // one null object
        assertAnyNull((Object) null);

        // some null objects
        assertAnyNull(null, 1, Integer.valueOf(1));
        assertAnyNull(null, "a", "b", null);

        // all null objects
        assertAnyNull(null, null);

        // empty list
        assertNoNull();

        // no null objects
        assertNoNull("");
        assertNoNull(1, 2);
        assertNoNull("abc", "", "abc", "ABC");
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertAnyNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertNoNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }
}
