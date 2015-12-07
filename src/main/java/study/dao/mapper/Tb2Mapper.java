package study.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import study.dao.model.Tb2;
import study.dao.model.Tb2Example;

public interface Tb2Mapper {
    int countByExample(Tb2Example example);

    int deleteByExample(Tb2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tb2 record);

    int insertSelective(Tb2 record);

    List<Tb2> selectByExample(Tb2Example example);

    Tb2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tb2 record, @Param("example") Tb2Example example);

    int updateByExample(@Param("record") Tb2 record, @Param("example") Tb2Example example);

    int updateByPrimaryKeySelective(Tb2 record);

    int updateByPrimaryKey(Tb2 record);
}