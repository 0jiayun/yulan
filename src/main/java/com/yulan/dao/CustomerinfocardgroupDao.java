package com.yulan.dao;

import com.yulan.pojo.Customerinfocardgroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerinfocardgroupDao {
    //获取所有
    List<Customerinfocardgroup> getCustomerinfocardgroups(@Param("start")Integer start, @Param("number") Integer number
                                                            , @Param("descp") String descp,@Param("deleted")int deleted);

    //统计
    int count(@Param("descp") String descp);

    //获取市场名
    String  getArea_codeName(String area_code);

    //获取区域名
    String getArea_districtName(String area_district);

    //获取客户类型名
    String getCustomer_typeName(String customer_type);

    //标记删除
    int updateDelete(@Param("Id") String Id,@Param("deleted")Integer deleted);





}
