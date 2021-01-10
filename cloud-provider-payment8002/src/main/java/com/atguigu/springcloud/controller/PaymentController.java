package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int rs = paymentService.create(payment);
        log.info("create is {}", rs);

        if (rs > 0) {
            return new CommonResult(200, "create success", rs);
        } else {
            return new CommonResult(444, "create fail", rs);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("getPaymentById is {}", payment);

        if (payment != null) {
            return new CommonResult(200, "getPaymentById success", payment);
        } else {
            return new CommonResult(444, "getPaymentById fail", payment);
        }
    }
}
