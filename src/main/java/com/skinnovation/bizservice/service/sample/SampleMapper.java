package com.skinnovation.bizservice.service.sample;

import com.skinnovation.bizservice.service.sample.vo.SampleAddVo;
import com.skinnovation.bizservice.service.sample.vo.SampleRespVo;
import com.skinnovation.bizservice.service.sample.vo.SampleSearchReqVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
    SampleRespVo findUser(SampleSearchReqVo vo);
    int insertUser(SampleAddVo vo);
}
