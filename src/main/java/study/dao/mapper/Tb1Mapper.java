package study.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import study.dao.model.Tb1;
import study.dao.model.Tb1Example;

public interface Tb1Mapper {
    int deleteByExample(Tb1Example example);

    int insert(Tb1 record);

    int insertSelective(Tb1 record);

    List<Tb1> selectByExample(Tb1Example example);

    int updateCol(@Param("id")int id, @Param("val")String val);
}