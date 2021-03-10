package com.bmicheck.controller;

import com.bmicheck.entity.BMIEntity;
import com.bmicheck.service.BMIService;
import com.bmicheck.service.BMIServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIController {
    @GetMapping("/bmicheck/{height}/{weight}")
    public ResponseEntity<BMIEntity> checkBMI(@PathVariable("height") Integer height, @PathVariable("weight") Integer weight){
        BMIService impl=new BMIServiceImpl();
        BMIEntity bmiEntity=impl.calculateBMI(height,weight);
        return new ResponseEntity<BMIEntity>(bmiEntity,HttpStatus.ACCEPTED);
    }
}
