package csu.skx.sell.service.impl;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import csu.skx.sell.dto.OrderDTO;
import csu.skx.sell.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Override
    public void create(OrderDTO orderDTO) {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
    }
}
