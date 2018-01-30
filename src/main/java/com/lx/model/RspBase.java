package com.lx.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class RspBase<T> implements Serializable {
    private String msg;
    private String code;
    private T data;
}
