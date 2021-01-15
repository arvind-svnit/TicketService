package com.servicenow.app.enums;

public enum Severity {
    Low(2),
    Medium(1),
    High(0);

    private int value;

    Severity(int value) {
        this.value = value;
    }
}
