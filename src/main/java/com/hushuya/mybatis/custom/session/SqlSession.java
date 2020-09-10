package com.hushuya.mybatis.custom.session;

public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
