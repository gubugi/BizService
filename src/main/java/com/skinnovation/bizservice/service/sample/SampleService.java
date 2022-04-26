package com.skinnovation.bizservice.service.sample;

import com.skinnovation.bizservice.service.sample.vo.SampleAddVo;
import com.skinnovation.bizservice.service.sample.vo.SampleReqVo;
import com.skinnovation.bizservice.service.sample.vo.SampleRespVo;
import com.skinnovation.bizservice.service.sample.vo.SampleSearchReqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SampleService {
    private final SampleMapper sampleMapper;

    public SampleService(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    public SampleRespVo findUser(SampleSearchReqVo vo) {
        return sampleMapper.findUser(vo);
    }

    public int insertUser(SampleAddVo vo) {
        return sampleMapper.insertUser(vo);
    }

}
