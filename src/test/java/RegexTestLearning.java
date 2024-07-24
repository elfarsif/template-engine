import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegexTestLearning {

    @Test
    public void testHowGroupCountWorks() throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertThat(matcher.groupCount())
                .isEqualTo(2);
    }
}
