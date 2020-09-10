package com.hushuya.mybatis.custom.session.defaultImpl;

import com.hushuya.mybatis.custom.cfg.Configuration;
import com.hushuya.mybatis.custom.session.SqlSession;
import com.hushuya.mybatis.custom.session.SqlSessionFactory;
import com.hushuya.mybatis.custom.session.defaultProxy.MapperProxy;
import com.hushuya.mybatis.custom.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class defaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public defaultSqlSession(Configuration configuration){
        this.configuration = configuration;
        connection = DataSourceUtil.getConnection(configuration);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(configuration.getMappers(),connection));
    }

    public void close() {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
