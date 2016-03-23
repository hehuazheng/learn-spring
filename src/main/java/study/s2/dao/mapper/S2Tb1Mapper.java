package study.s2.dao.mapper;

import java.util.List;
import study.s2.dao.model.S2Tb1;
import study.s2.dao.model.S2Tb1Example;

public interface S2Tb1Mapper {
    int deleteByExample(S2Tb1Example example);

    int insert(S2Tb1 record);

    int insertSelective(S2Tb1 record);

    List<S2Tb1> selectByExample(S2Tb1Example example);
}