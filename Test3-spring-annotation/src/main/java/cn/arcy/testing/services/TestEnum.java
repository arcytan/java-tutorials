package cn.arcy.testing.services;

import java.util.Arrays;

public enum TestEnum {

    TEST1(1, "test1"),
    TEST2(2, "test2")
    ;

    int code;

    String name;

    TestEnum(int code, String test1) {
        this.code = code;
        this.name = test1;
    }

    public static void getCodeName()
    {
        System.out.println(Arrays.stream(TestEnum.values()).findAny().get());
    }
}
