package com.skinnovation.bizservice.common.service;

import com.skinnovation.bizservice.common.entity.ErrorType;
import com.skinnovation.bizservice.common.exception.LanguageSetType;
import com.skinnovation.bizservice.common.entity.LanguageSetVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface LanguageService {
    public List getLanguageSet();
    public Map<String, List<LanguageSetVo>> getLanguageSetList(LanguageSetType setType);
    public String getErrMessage(ErrorType errorType, LanguageSetType set);
}
