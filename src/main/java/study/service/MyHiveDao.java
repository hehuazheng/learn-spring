package study.service;

import study.anno.UseMyFactory;

/**
 * Created on 2016/11/2.
 */
@UseMyFactory
public interface MyHiveDao {
    String showSth(String name);
}
