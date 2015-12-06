package study.dao.study2.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import study.dao.study2.model.S2tb2;
import study.dao.study2.model.S2tb2Example;

public interface S2tb2Mapper {
    int countByExample(S2tb2Example example);

    int deleteByExample(S2tb2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(S2tb2 record);

    int insertSelective(S2tb2 record);

    List<S2tb2> selectByExample(S2tb2Example example);

    S2tb2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") S2tb2 record, @Param("example") S2tb2Example example);

    int updateByExample(@Param("record") S2tb2 record, @Param("example") S2tb2Example example);

    int updateByPrimaryKeySelective(S2tb2 record);

    int updateByPrimaryKey(S2tb2 record);
}