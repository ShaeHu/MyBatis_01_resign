package com.hushuya.mybatis.custom.session.defaultImpl;

import com.hushuya.mybatis.custom.cfg.Configuration;
import com.hushuya.mybatis.custom.session.SqlSession;
import com.hushuya.mybatis.custom.session.SqlSessionFactory;
import com.hushuya.mybatis.custom.utils.XMLConfigBuilder;

import java.io.InputStream;

public class defaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public defaultSqlSessionFactory(Configuration configuration){
       this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new defaultSqlSession(configuration);
    }
}
