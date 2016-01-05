package study.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import study.dao.model.Tb1;
import study.dao.model.Tb1Example;

public interface Tb1Mapper {
    int countByExample(Tb1Example example);

    int deleteByExample(Tb1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tb1 record);

    int insertSelective(Tb1 record);

    List<Tb1> selectByExample(Tb1Example example);

    Tb1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tb1 record, @Param("example") Tb1Example example);

    int updateByExample(@Param("record") Tb1 record, @Param("example") Tb1Example example);

    int updateByPrimaryKeySelective(Tb1 record);

    int updateByPrimaryKey(Tb1 record);
}