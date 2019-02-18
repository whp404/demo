package com.imooc.controller;

import com.imooc.Repository.GirlRepository;
import com.imooc.pojo.Girl;
import com.imooc.service.GirlService;
import com.imooc.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        return  girlRepository.findAll();
    }


    @PostMapping("/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @GetMapping("/girls/{id}")
    public  Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }

    @PutMapping("/girls/{id}")
    public void girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girlRepository.save(girl);
    }

    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id)
    {
        girlRepository.deleteById(id);
    }

    @GetMapping("/girl/{age}")
    public List<Girl> getGirlByAge(@PathVariable("age") Integer age){
        return  girlRepository.findByAge(age);
    }

    @PostMapping("/girlAdd")
    public Girl girlAddWithGirl(@Valid Girl girl, BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           System.out.print(bindingResult.getFieldError().getDefaultMessage());
           return null;
       }
        return girlRepository.save(girl);
    }


    @GetMapping("/girls/getAge/{id}")
    public Message getAge(@PathVariable("id") Integer id) throws Exception {

        return girlService.getAge(id);
    }
}
