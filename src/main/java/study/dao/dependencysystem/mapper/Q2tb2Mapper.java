package study.dao.dependencysystem.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import study.dao.dependencysystem.model.Q2tb2;
import study.dao.dependencysystem.model.Q2tb2Example;

public interface Q2tb2Mapper {
    int countByExample(Q2tb2Example example);

    int deleteByExample(Q2tb2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Q2tb2 record);

    int insertSelective(Q2tb2 record);

    List<Q2tb2> selectByExample(Q2tb2Example example);

    Q2tb2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Q2tb2 record, @Param("example") Q2tb2Example example);

    int updateByExample(@Param("record") Q2tb2 record, @Param("example") Q2tb2Example example);

    int updateByPrimaryKeySelective(Q2tb2 record);

    int updateByPrimaryKey(Q2tb2 record);
}