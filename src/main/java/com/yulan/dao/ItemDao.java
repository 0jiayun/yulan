package com.yulan.dao;

import com.yulan.pojo.Item;
import com.yulan.pojo.StockShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDao {

    Item getWallpaperInfo(@Param("paperType") String paperType);

    String getProductVersion(@Param("itemVersion") String itemVersion);

    String getProductBrand(@Param("productBrand") String productBrand);
    //客户品牌查询权限
    String userBrandAuthority(@Param("CID") String cid, @Param("ITEM_NO") String itemNo);

    List<StockShow> getStockShow(@Param("ITEM_NO")String itemNo);
}
