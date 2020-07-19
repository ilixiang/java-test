package se;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.stream.Stream;

public class EnumTest {
    @Test
    public void testEnum() {
        ColorEnum color = ColorEnum.BLUE;
        // 编译器报错 incompatible types: se.SeasonEnum cannot be converted to se.ColorEnum
        // color = SeasonEnum.AUTUMN;
        // 获取元素名称
        System.out.println(color);
        // 通过values()迭代操作全部元素
        for(ColorEnum element: ColorEnum.values()) {
            System.out.println(element);
        }
        // 获取元素的序号
        System.out.println(color.ordinal());
    }

    @Test
    public void testEnumWithMember() {
        SeasonEnum season = SeasonEnum.SPRING;
        System.out.println(String.format("农历%d月 - %d月是%s季", season.getFromMonth(),
                season.getToMonth(), season.getDesc()));
    }

    @Test
    public void testEnumWithAbstractMethod() {
        BasicOperation op = BasicOperation.PLUS;
        Enum e = op;
        SeasonEnum season = (SeasonEnum)e;
        System.out.println(op.apply(1, 2));
    }

    @Test
    public void testEnumWithCollection() {
        BasicOperation op = BasicOperation.PLUS;
        Enum e = op;
        EnumSet<SeasonEnum> set = EnumSet.of(SeasonEnum.SPRING, SeasonEnum.SUMMER);
        System.out.println(set.contains(e));
    }
}
