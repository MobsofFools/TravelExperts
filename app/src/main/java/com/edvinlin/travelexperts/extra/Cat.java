package com.edvinlin.travelexperts.extra;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName("fact")
    private String fact;
    @SerializedName("length")
    private Integer length;

    public Cat(String fact, Integer length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
