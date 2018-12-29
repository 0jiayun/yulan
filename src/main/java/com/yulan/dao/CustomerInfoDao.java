package com.yulan.dao;

import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontract_v2015_paa;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerInfoDao {

    CustomerInfoCard getCustomerInfo(@Param("CID") String cID);

    List<Map<String,Object>> getInfobyStateandmarketName(@Param("start")Integer start, @Param("number") Integer number,@Param("year")String year);

    List<Map> getInfoBySate(@Param("year")String year);

    int count(@Param("year")String year);

    List<CustomerInfoCard> getAllinfo(@Param("start")Integer start, @Param("number") Integer number,
                                      @Param("year")String year,@Param("state")String state,
                                      @Param("find")String find);

    int countInfo(@Param("year")String year,@Param("state")String state,
                  @Param("find")String find);

    List<Map<String,Object>> getAllStates();



    /**
     *
     * @param customerInfoCard
     * @return
     */
    boolean updateCustomerInfo(CustomerInfoCard customerInfoCard);

    /**
     *
     * @param cCID
     * @return
     */
    YLcontract_v2015_paa getYLcontract(@Param("CCID") String cCID);

    /**
     *
     * @param yLcontract_v2015_paa
     * @return
     */
    boolean insertYLcontract(YLcontract_v2015_paa yLcontract_v2015_paa);

    String getXAreaDistrictName(@Param("REGION_ID") String xAreaDistrict3);

    String getXDistrict(@Param("DISTRICT_ID") String xDistrict);

    //获取业务员所有区域
    List<Map<String,Object>> getAllArea(@Param("cid")String cid);

    List<Map<String,Object>> getAllStatisticsInfo(@Param("market") String market,@Param("userCID") String userCID,
                                                  @Param("userCName") String userCName);

    List<Map<String,Object>> getInfoandYlc(@Param("find")String find,@Param("year")String year,
                                           @Param("infoState")String infoStat,@Param("ylcState")String ylcState);

    int countInfoandYlc(@Param("find")String find,@Param("year")String year,
                        @Param("infoState")String infoStat,@Param("ylcState")String ylcState);
    //业务员审核资料卡
    boolean businessCheckCustomerInfoCard(@Param("CID") String cid ,@Param("STATE") String state,@Param("MEMO") String memo);

    //资料卡执行状态汇总
    List<Map<String,Object>> getAllCustomerInfoCardState(@Param("CONTRACTYEAR") String year);

    //获取所有资料卡所属的所有大区
    //暂时用不上这个方法
    List<Map<String,Object>> getAllCustomerInfoCardArea(@Param("CONTRACTYEAR") String year);

    //获取每个大区下的资料卡执行状态统计
    List<Map<String,Object>> getCustomerInfoCardStateByArea(@Param("CONTRACTYEAR") Integer year);

}
