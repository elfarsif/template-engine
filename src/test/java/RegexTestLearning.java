import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegexTestLearning {

    @Test
    public void testHowGroupCountWorks() throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "needle";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertThat(matcher.find())
                .isTrue();
        assertThat(matcher.start())
                .as("Wrong start index of 1st match")
                .isEqualTo(4);
        assertThat(matcher.end())
                .as("Wrong end index of 1st match")
                .isEqualTo(10);
        assertThat(matcher.find())
                .isTrue();
        assertThat(matcher.start())
                .as("Wrong start index of 1st match")
                .isEqualTo(22);
        assertThat(matcher.end())
                .as("Wrong end index of 1st match")
                .isEqualTo(28);
    }
}
