package commons;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LangTest {

    @Test
    public void stringUtilsTest() throws InterruptedException {
        assertThat(StringUtils.equals(null, null)).isEqualTo(true);
        assertThat(StringUtils.equals("", "")).isEqualTo(true);

        assertThat(StringUtils.isBlank("    ")).isEqualTo(true);
        assertThat(StringUtils.isBlank(null)).isEqualTo(true);
    }

}
