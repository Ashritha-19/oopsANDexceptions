package com.neoteric.oopsandexceptions.product.service;

public enum PaymentEnum {

    SUCCES(100),

    FAILED(200),

    PENDING(300);

    private int code;


     PaymentEnum(int code){
         this.code = code;
     }


    public int getCode() {
        return code;
    }
}
