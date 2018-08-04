package csu.skx.sell.service.impl;

import csu.skx.sell.dto.OrderDTO;
import csu.skx.sell.enums.ExceptionEnum;
import csu.skx.sell.exception.SellException;
import csu.skx.sell.service.BuyerService;
import csu.skx.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderid) {

        return checkOrderOwner(openid,orderid);
    }

    @Override
    public OrderDTO cnacelOrder(String openid, String orderid) {
        OrderDTO orderDTO = checkOrderOwner(openid,orderid);
        if(orderDTO == null){
            log.error("【取消订单】 查不到该订单，orderid = {}",orderid);
            throw new SellException(ExceptionEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openid, String orderid){
        OrderDTO orderDTO = orderService.getOne(orderid);
        if(orderDTO == null){

            return null;
        }
        //判断是否是自己的openid
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】 订单的openid不一致，openid = {},orderDTO = {}",openid,orderDTO);
            throw new SellException(ExceptionEnum.ORDER_OPENID_NOT_MATCH);
        }
        return orderDTO;
    }
}
