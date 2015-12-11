package study.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import study.dao.model.OpLog;
import study.dao.model.OpLogExample;

public interface OpLogMapper {
    int countByExample(OpLogExample example);

    int deleteByExample(OpLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    List<OpLog> selectByExample(OpLogExample example);

    OpLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpLog record, @Param("example") OpLogExample example);

    int updateByExample(@Param("record") OpLog record, @Param("example") OpLogExample example);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);
}