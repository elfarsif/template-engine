import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class TemplateParseTest {

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        TemplateParse parse = new TemplateParse();
        List<String> segments = parse.parse("");
        assertThat(segments.size())
                .as("Number of segments")
                .isEqualTo(1);
        assertThat(segments.get(0))
                .isEqualTo("");
    }
}
