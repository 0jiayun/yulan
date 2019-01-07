package com.yulan.dao;

import com.yulan.pojo.YLcontract_v2015;
import com.yulan.pojo.YLcontractentry;

import com.yulan.pojo.YLcontractentryShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface YLcontractentryDao {
    List<Map<String,Object>> getYLcbyStateandCID(@Param("start")Integer start, @Param("number") Integer number,@Param("year")String year);

    List<Map> getYLcBySate(@Param("year")String year);

    String getArea_code(String CID);//关联customer

    String getAreaName(String area_code);//关联Area_code

    String getCenter_mangerId(@Param("area_code")String area_code);//关联Area_owner

    String getName(String owner);//HES_EMPLOYEE

    int count(@Param("year")String year);

    List<Map<String,Object>> getAllStates();

    //获取状态
    String getState(@Param("CID")String CID,@Param("year")Integer year,@Param("state")String state);


    YLcontract_v2015 getYLcontract_v2015(@Param("CCID") String ccid);

    boolean createYLcontract_v2015(YLcontract_v2015 yLcontract_v2015);

    boolean createYLcontractentry(YLcontractentry yLcontractentry);

    boolean updateYLcontract_v2015(YLcontract_v2015 yLcontract_v2015);

    boolean updateYLcontractentry(YLcontractentry yLcontractentry);

    YLcontractentryShow getYLcontractHTML(@Param("ID") Integer ID);

    YLcontractentry getYLcontractentry(@Param("CID") String cid);

    boolean checkYLcontractentry(@Param("CID") String cid,@Param("STATE") String state,@Param("WFMEMO") String wfmemo);

    List<YLcontractentry> getAllYlcs(@Param("start")Integer start,@Param("number") Integer number,@Param("signed")String signed);
    int countYlcs(@Param("signed")String signed);

    //联表查询获取所需协议书集合
    List<Map<String,Object>> getAllYs(@Param("start")Integer start,@Param("number") Integer number,
                                      @Param("signed")Integer signed,@Param("cid")String cid,
                                      @Param("year")Integer year,@Param("area_1")String area_1,
                                      @Param("area_2")String area_2,@Param("find")String find);
    int countYs(@Param("signed")Integer signed,@Param("cid")String cid,
                @Param("year")Integer year,@Param("area_1")String area_1,
                @Param("area_2")String area_2,@Param("find")String find);
    //协议书执行状态汇总
    List<Map<String,Object>> getAllYLcontractentryState(@Param("CYEAR") String year);

    List<Map<String,Object>> getYLcontractentryStateByArea(@Param("CYEAR") String year);
}
