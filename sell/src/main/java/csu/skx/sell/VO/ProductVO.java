package csu.skx.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductVO<T> {

    @JsonProperty("name")
    private String categoryname;

    @JsonProperty("type")
    private Integer categorytype;

    @JsonProperty("foods")
    private T productInfoVOList;
}
