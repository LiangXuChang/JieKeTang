package com.school.service.impl;

import com.school.dataobject.Doc;
import com.school.repository.DocRepository;
import com.school.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 梁栩菖
 * 2018/10/29 14:04
 */
@Service
public class DocServiceImpl implements DocService {

    @Autowired
    private DocRepository docRepository;

    public Doc saveDoc(Doc doc){
        doc.setCId(doc.getCId());
        doc.setDocUrl(doc.getDocUrl());
        return docRepository.save(doc);
    }
}
