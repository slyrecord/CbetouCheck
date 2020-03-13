package test.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory factory;

    private MyBatisUtil() {}

    static
    {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybytis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory()
    {
        return factory;
    }
}
