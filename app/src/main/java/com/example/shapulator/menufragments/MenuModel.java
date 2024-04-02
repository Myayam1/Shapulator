package com.example.shapulator.menufragments;

import android.graphics.drawable.Drawable;

public class MenuModel {
    private String name, desc;
    private Drawable src;

    public MenuModel(String name, String desc, Drawable src) {
        this.name = name;
        this.desc = desc;
        this.src = src;
    }

    public String getName() { return name; }
    public String getDesc() {
        return desc;
    }

    public Drawable getSrc() { return src; }
}
