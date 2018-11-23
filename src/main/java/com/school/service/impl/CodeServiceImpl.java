package com.school.service.impl;

import com.school.dataobject.Code;
import com.school.repository.CodeRepository;
import com.school.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 梁栩菖
 * 2018/10/29 14:04
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepository codeRepository;

    public Code saveCode(Code code){
        code.setCId(code.getCId());
        code.setCodeUrl(code.getCodeUrl());
        return codeRepository.save(code);
    }

}
