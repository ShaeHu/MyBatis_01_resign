package com.hushuya.mybatis;


import com.hushuya.mybatis.custom.io.Resources;
import com.hushuya.mybatis.custom.session.SqlSession;
import com.hushuya.mybatis.custom.session.SqlSessionFactory;
import com.hushuya.mybatis.custom.session.SqlSessionFactoryBuilder;
import com.hushuya.mybatis.dao.IUserDao;
import com.hushuya.mybatis.domain.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.dom4j.io.OutputFormat;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.获取工厂类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生成sqlsession类
        SqlSession session = factory.openSession();
        //3.动态代理生成持久层接口实现类
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        //4.执行sql
        List<User> users = iUserDao.findAll();
        //5.遍历结果
        for (User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();

//        try {
//            Document document = DocumentHelper.createDocument();
//            Element root = document.addElement("cars");
//            Element supercarElement = root.addElement("supercars")
//                    .addAttribute("company", "Ferrai");
//
//            supercarElement.addElement("carname")
//                    .addAttribute("type", "Ferrari 101")
//                    .addText("Ferrari 101").addNamespace("aa","/com/hushuya");
//
//            supercarElement.addElement("carname")
//                    .addAttribute("type", "sports")
//                    .addText("Ferrari 202");
//
//            // Pretty print the document to System.out
//            OutputFormat format = OutputFormat.createPrettyPrint();
//            XMLWriter writer;
//            writer = new XMLWriter(System.out, format);
//            writer.write(document);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
