package com.truongvietdung.mapper;

public interface BaseMapper<T,S,U> {

    T convertSave(S s);

    T convertUpdate(U u);
}
