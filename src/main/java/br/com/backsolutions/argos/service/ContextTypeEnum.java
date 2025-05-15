package br.com.backsolutions.argos.service;

public enum ContextTypeEnum {
    REMOVAL(1),
    ADDITION(2),
    CHECK(3);

    private final int code; //'final' means that the value of this variable cannot be changed after initialized

    ContextTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
