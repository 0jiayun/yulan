package com.yulan.controller;

import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontract_v2015_paa;
import com.yulan.service.CustomerInfoService;
import com.yulan.utils.FileUpload;
import com.yulan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customerInfo")
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;

    private Response response;

    private static final String CUSTOMER_DIRECTORY = "/customer-image";
    private static final String YLcontract_Directory = "/YLcontract-image";

    private CustomerInfoCard customerInfoCard;

    /*
    *这里的CID应该是客户的loginName
     */
   /* @RequestMapping(value = "getCustomerInfo")
    @ResponseBody
    public CustomerInfoCard getCustomerInfo(@RequestParam("CID") String cID)throws Exception{
        System.out.println(customerInfoService.getCustomerInfo(cID));
        return customerInfoService.getCustomerInfo(cID);
    }*/

    /**
     * exchart显示资料卡执行汇总
     * @return
     */
    @RequestMapping("showStateEchart")
    @ResponseBody
    public Map<String, Object> showStateEchart(@RequestParam("year")String year){
        if (year.equals("")){
            year=null;
        }
        return customerInfoService.showStateEchart(year);
    }

    @RequestMapping("getAllSta")
    @ResponseBody
    public  Map<String,Object> getAllSta(@RequestParam(name = "limit", required = false) Integer limit,
                                         @RequestParam(name = "page", required = false) Integer page,
                                         @RequestParam("year")String year) throws UnsupportedEncodingException {
        if (year.equals("")){
            year=null;
        }
        if(limit==null||page==null) {
            page=null;
            limit=null;
        } else {
            page=(page-1)*limit+1;
        }
        int lastNum=page+limit-1;
        Map map = customerInfoService.getInfobyStateandmarketName(page,lastNum,year);
        map.put("code",0);
        map.put("msg","");
        return map;

    }

    @RequestMapping("getAllSates")
    @ResponseBody
    public List<Map<String,Object>> getAllStates(){
        return customerInfoService.getAllStates();
    }

    /**
     * 文件上传接口，有两个值一个是上传的文件，一个是文件类型
     * 文件类型有两种，一种是Customer , 一种是YLcontract
     * @param file
     * @param imgType
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public Map uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("imgType") String imgType){
        int code = 0;
        String msg = null;
        Map<String,Object> data = new HashMap<>(2);

        if(imgType.equals("Customer")){
            Map<String,Object> value = FileUpload.copyCustomerImg(file);
            String name = (String) value.get("fileName");
            msg = value.get("code").equals("SUCCESS")?"":"上传失败";
            code = value.get("code").equals("SUCCESS")?0:1;
            data.put("path",CUSTOMER_DIRECTORY + "/" + name);
            data.put("type",value.get("fileType"));

        }else if(imgType.equals("YLcontract")){
            Map<String,Object> value = FileUpload.copyYLcontractImg(file);
            String name = (String) value.get("fileName");
            msg = value.get("code").equals("SUCCESS")?"":"上传失败";
            code = value.get("code").equals("SUCCESS")?0:1;
            data.put("path",YLcontract_Directory + "/" + name);
            data.put("type",value.get("fileType"));
        }

        Map<String,Object> result = new HashMap<>(3);
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return  result;
    }

    /**
     * 里的CID应该是客户的loginName
     * 读取客户资料卡
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getCustomerInfo")
    @ResponseBody
    public Map getCustomerInfo(@RequestBody Map<String,Object> data)throws Exception{
        String cID = (String)data.get("CID");
        if(customerInfoService.getCustomerInfo(cID) == null){
            return response.getResponseMap(1,"用户数据不存在" ,customerInfoService.getCustomerInfo(cID));
        }else{
            return response.getResponseMap(0,"SUCCESS" ,customerInfoService.getCustomerInfo(cID));

        }
    }

    /**
     * 更新客户资料卡
     * @param customerInfoCard
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateCustomerInfo")
    @ResponseBody
    public Map updateCustomerInfo(@RequestBody CustomerInfoCard customerInfoCard)throws Exception{
        if(customerInfoService.updateCustomerInfo(customerInfoCard)){
            return Response.getResponseMap(0,"更新成功",null);
        }else{
            return Response.getResponseMap(1,"更新失败",null);
        }
    }

    /**
     * 得到委托授权书
     * @param data
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "getYLcontract")
    @ResponseBody
    public Map getYLcontract(@RequestBody Map<String,Object> data)throws IOException {
        String ccID = (String)data.get("CCID");
        if(customerInfoService.getYLcontract(ccID) == null){
            return response.getResponseMap(1,"用户数据不存在" ,customerInfoService.getYLcontract(ccID));
        }else{
            return response.getResponseMap(0,"SUCCESS" ,customerInfoService.getYLcontract(ccID));
        }
    }

    /**
     * 创建委托授权书
     * @param yLcontract_v2015_paa
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "createYLcontract")
    @ResponseBody
    public Map createYLcontract(@RequestBody YLcontract_v2015_paa yLcontract_v2015_paa)throws IOException{
        if(customerInfoService.createYLcontract(yLcontract_v2015_paa)){
            return Response.getResponseMap(0,"创建成功",null);
        }else{
            return Response.getResponseMap(1,"创建失败",null);
        }
    }

    /**
     * 经销授权书接口
     * @param data
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "getAuthorization")
    @ResponseBody
    public Map getAuthorization(@RequestBody Map<String,Object> data)throws IOException {
        String cid = (String)data.get("cid");
        Map<String,Object> map = new HashMap<>();
        customerInfoCard = customerInfoService.getCustomerInfo(cid);
        map.put("districtText",customerInfoCard.getDistrictText());
        map.put("areaDistrict2Text",customerInfoCard.getAreaDistrict2Text());
        map.put("areaDistrict3Text",customerInfoCard.getAreaDistrict3Text());
        return  map;
    }

    @ResponseBody@RequestMapping("getAllStatisticsInfo")
    public Map getAllStatisticsInfo(@RequestParam(value = "userCID",required = false)String userCID,@RequestParam(value = "userCName",required = false)String userCName,
                                    @RequestParam(value = "managerCID") String managerCID) {
        return Response.getResponseMap(0,"",customerInfoService.getAllStatisticsInfo(userCID,userCName,managerCID));
    }


}
