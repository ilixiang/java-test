import entity.ValidateEntity;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorTest {
    @Test
    public void notNullTest() {
        ValidateEntity entity = new ValidateEntity();
        entity.setDesc(null);
        entity.setEmail("This is not an Email address");
        entity.setList(Arrays.asList(1, 2, 3, 4, 6));
        Set<ConstraintViolation<ValidateEntity>> result = Validation
                .buildDefaultValidatorFactory().getValidator().validate(entity);
        List<String> messages = result.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        messages.forEach(System.out::println);
    }

}
