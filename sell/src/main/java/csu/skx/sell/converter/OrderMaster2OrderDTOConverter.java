package csu.skx.sell.converter;
import csu.skx.sell.domain.OrderMaster;
import csu.skx.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e -> convert(e) ).collect(Collectors.toList());
    }
}
