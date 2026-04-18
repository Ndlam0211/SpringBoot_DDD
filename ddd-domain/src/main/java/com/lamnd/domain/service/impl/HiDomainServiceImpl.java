package com.lamnd.domain.service.impl;

import com.lamnd.domain.repository.HiDomainRepository;
import com.lamnd.domain.service.HiDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiDomainServiceImpl implements HiDomainService {

    @Autowired
    private HiDomainRepository hiDomainRepository;

    @Override
    public String sayHi(String name) {
        return hiDomainRepository.sayHi(name);
    }
}
