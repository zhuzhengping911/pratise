package com.zzp.pratise.reflect.pojo;

/**
 * Created by zhuzhengping
 * on 2017/8/17.
 */
public class FinalClass {

    private final String FINAL_VALUE = "FINAL";

    private final String FINAL_VALUE_MODIFY;

    private final String FINAL_VALUE_CHOSE = null == null ? "CHOSE" : null;

    public FinalClass() {
        this.FINAL_VALUE_MODIFY = "MODIFY";
    }

    public String getFINAL_VALUE() {
        return FINAL_VALUE;
    }

    public String getFINAL_VALUE_MODIFY() {
        return FINAL_VALUE_MODIFY;
    }

    public String getFINAL_VALUE_CHOSE() {
        return FINAL_VALUE_CHOSE;
    }
}
