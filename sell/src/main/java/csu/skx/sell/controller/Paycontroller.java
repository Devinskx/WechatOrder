package csu.skx.sell.controller;

import csu.skx.sell.dto.OrderDTO;
import csu.skx.sell.enums.ExceptionEnum;
import csu.skx.sell.exception.SellException;
import csu.skx.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("pay")
public class Paycontroller {

    @Autowired
    private OrderService orderService;

    @GetMapping("create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl){

        //1.查询订单
        OrderDTO orderDTO = orderService.getOne(orderId);
        if(orderDTO == null){
            throw new SellException(ExceptionEnum.ORDER_NOT_EXIST);
        }

        //2.发起支付

    }
}
