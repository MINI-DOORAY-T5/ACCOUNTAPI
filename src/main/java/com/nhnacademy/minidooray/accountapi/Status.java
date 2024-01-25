package com.nhnacademy.minidooray.accountapi;

public enum Status {
    active("활성"),
    dormant("휴먼"),
    closed("종료");

    private final String statu;

    private Status(String statu) {
        this.statu = statu;
    }

    public String getStatu() {
        return statu;
    }


}
