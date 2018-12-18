package com.yulan.dao;

import com.yulan.pojo.AreaRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaRegionDao {

    List<AreaRegion> getProvince();

    List<AreaRegion> getCity(@Param("PARENT_PROVINCE") String parentProvince);

    List<AreaRegion> getCountry(@Param("PARENT_CITY_ID") String parentCityID);
}
