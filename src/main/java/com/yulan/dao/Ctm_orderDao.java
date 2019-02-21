package com.yulan.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Ctm_orderDao {
    List<Map<String,Object>> getOrders(@Param("start")Integer start, @Param("number") Integer number,
                                       @Param("cid")String cid, @Param("state_id")String state_id,
                                       @Param("find")String find);

    Integer countOrders(@Param("cid")String cid,@Param("state_id")String state_id,
                        @Param("find")String find);
}
