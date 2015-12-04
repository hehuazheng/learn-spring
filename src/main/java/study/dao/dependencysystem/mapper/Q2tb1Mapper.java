package study.dao.dependencysystem.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import study.dao.dependencysystem.model.Q2tb1;
import study.dao.dependencysystem.model.Q2tb1Example;

public interface Q2tb1Mapper {
    int countByExample(Q2tb1Example example);

    int deleteByExample(Q2tb1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Q2tb1 record);

    int insertSelective(Q2tb1 record);

    List<Q2tb1> selectByExample(Q2tb1Example example);

    Q2tb1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Q2tb1 record, @Param("example") Q2tb1Example example);

    int updateByExample(@Param("record") Q2tb1 record, @Param("example") Q2tb1Example example);

    int updateByPrimaryKeySelective(Q2tb1 record);

    int updateByPrimaryKey(Q2tb1 record);
}