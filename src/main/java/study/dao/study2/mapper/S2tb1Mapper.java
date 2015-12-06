package study.dao.study2.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import study.dao.study2.model.S2tb1;
import study.dao.study2.model.S2tb1Example;

public interface S2tb1Mapper {
    int countByExample(S2tb1Example example);

    int deleteByExample(S2tb1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(S2tb1 record);

    int insertSelective(S2tb1 record);

    List<S2tb1> selectByExample(S2tb1Example example);

    S2tb1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") S2tb1 record, @Param("example") S2tb1Example example);

    int updateByExample(@Param("record") S2tb1 record, @Param("example") S2tb1Example example);

    int updateByPrimaryKeySelective(S2tb1 record);

    int updateByPrimaryKey(S2tb1 record);
}