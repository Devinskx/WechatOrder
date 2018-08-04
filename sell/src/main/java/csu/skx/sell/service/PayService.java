package csu.skx.sell.service;

import csu.skx.sell.dto.OrderDTO;

public interface PayService {
    void create(OrderDTO orderDTO);

}

