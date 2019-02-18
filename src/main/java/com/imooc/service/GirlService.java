package com.imooc.service;

import com.imooc.Repository.GirlRepository;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.pojo.Girl;
import com.imooc.util.Message;
import com.imooc.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public Message getAge(Integer id)throws Exception{
        Optional<Girl> girl = girlRepository.findById(id);
        if(girl.isPresent()){
            Integer age = girl.get().getAge();
            if(age<10){
                throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
            }else if(age>10 && age<16){
                throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
            }

            return MessageUtil.succcess(girl);
        }
        return MessageUtil.error(103,"找不到");
    }
}
