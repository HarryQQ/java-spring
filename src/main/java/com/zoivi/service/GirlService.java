package com.zoivi.service;

import com.zoivi.domain.Girl;
import com.zoivi.enums.ResultEnums;
import com.zoivi.exception.GirlException;
import com.zoivi.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/4/30 0030.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(22);
        girlA.setCupSize("A");
        girlRepository.save(girlA);
        Girl girlB = new Girl();
        girlB.setAge(21);
        girlB.setCupSize("C");
        girlRepository.save(girlB);
    }

    public Girl getAgeMessage(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age <= 10) {
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }
        return girl;
    }

    //
    public Girl findOne(Integer id){
       return girlRepository.findOne(id);
    }
}
