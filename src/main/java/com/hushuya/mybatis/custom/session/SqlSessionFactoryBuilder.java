package com.hushuya.mybatis.custom.session;

import com.hushuya.mybatis.custom.cfg.Configuration;
import com.hushuya.mybatis.custom.session.defaultImpl.defaultSqlSessionFactory;
import com.hushuya.mybatis.custom.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);
        return new defaultSqlSessionFactory(configuration);
    }
}
