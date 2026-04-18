package com.lamnd.infrastructure.persistence.repository;

import com.lamnd.domain.repository.HiDomainRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HiInfraRepositoryImpl implements HiDomainRepository {

    @Override
    public String sayHi(String name) {
        return "Infrastructure Hi, " + name + "!";
    }
}
