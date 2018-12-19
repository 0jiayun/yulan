package com.yulan.controller;

import com.yulan.pojo.Customer;
import com.yulan.pojo.Customerinfocardgroup;
import com.yulan.service.CustomerInfoService;
import com.yulan.service.CustomerService;
import com.yulan.service.CustomerinfocardgroupService;
import com.yulan.utils.Response;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerinfocardgroupService customerInfoCardGroupService;
    @Autowired
    private CustomerInfoService customerInfoService;
    @ResponseBody@RequestMapping("createDataCards")
    public Map createDataCard(Map<String,Object> datas) {
        String customerCode = (String) datas.get("customerCode");
        String descp = (String) datas.get("descp");
        List<String> areaCodes = (List<String>) datas.get("areaCodes");
        List<String> areaDistricts = (List<String>) datas.get("areaDistricts");
        List<String> customerTypes = (List<String>) datas.get("customerTypes");
        List<Customer> customers = customerService.getCustomers(customerCode,areaCodes,areaDistricts,customerTypes);
        Customerinfocardgroup customerinfocardgroup = customerInfoCardGroupService.getCustomerInfoCardGroupByName(null);
        if(customerinfocardgroup==null) {
            customerinfocardgroup = new Customerinfocardgroup();
            customerinfocardgroup.setId(StringUtil.createStringID());
            customerInfoCardGroupService.addCustomerInfoCardGroup(customerinfocardgroup);
        }
        return Response.getResponseMap(0,"",null);
    }
}
