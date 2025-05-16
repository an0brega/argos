package br.com.backsolutions.argos.enums;

/**
 * Contains the three different enum values for the situations where the storage content should be printed.
 */
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
