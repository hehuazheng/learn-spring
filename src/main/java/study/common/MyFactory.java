package study.common;

import org.springframework.beans.factory.FactoryBean;
import study.service.MyHiveDao;

/**
 * Created on 2016/11/2.
 */
public class MyFactory<T> implements FactoryBean<T> {
    private Class<T> mapperInterface;

    public void setMapperInterface(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        if(mapperInterface == MyHiveDao.class) {
            return  (T)new MyHiveDao() {
                @Override
                public String showSth(String name) {
                    return "my hive dao: " + name;
                }
            };
        }
        return null;
    }

    @Override
    public Class<T> getObjectType() {
        return this.mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
