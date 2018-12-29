package com.yulan.controller;

import com.yulan.pojo.Customer;
import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.Customerinfocardgroup;
import com.yulan.service.CustomerInfoCardService;
import com.yulan.service.CustomerService;
import com.yulan.service.CustomerinfocardgroupService;
import com.yulan.utils.Response;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerinfocardgroupService customerInfoCardGroupService;
    @Autowired
    private CustomerInfoCardService customerInfoCardService;
    @ResponseBody@RequestMapping("createDataCards")
    public Map createDataCard(@RequestBody Map<String,Object> datas) throws UnsupportedEncodingException {
        String customerCode = (String) datas.get("customerCode");
        String descp = (String) datas.get("descp");
        List<String> areaCodes = (List<String>) datas.get("areaCodes");
        List<String> areaDistricts = (List<String>) datas.get("areaDistricts");
        List<String> customerTypes = (List<String>) datas.get("customerTypes");
        if(areaCodes!=null) {
            areaCodes=areaCodes.size()==0?null:areaCodes;
        }
        if(areaDistricts!=null) {
            areaDistricts=areaDistricts.size()==0?null:areaDistricts;
        }
        if(customerTypes!=null) {
            customerTypes=customerTypes.size()==0?null:customerTypes;
        }
        List<Customer> customers = customerService.getCustomers(customerCode,areaCodes,areaDistricts,customerTypes);
        descp = StringUtil.setUtf8(descp);
        Customerinfocardgroup customerinfocardgroup = customerInfoCardGroupService.getCustomerInfoCardGroupByName(descp);
        if(customerinfocardgroup==null) {
            customerinfocardgroup = new Customerinfocardgroup();
            customerinfocardgroup.setId(StringUtil.createStringID());
            customerinfocardgroup.setDescp(descp);
            customerInfoCardGroupService.addCustomerInfoCardGroup(customerinfocardgroup);
        } else {
            List<Customer> customersExist = customerService.getCustomersByGroupID(customerinfocardgroup.getId());
            customers.removeAll(customersExist);
        }
        int result = 0;
        for (Customer customer:customers) {
            CustomerInfoCard customerInfoCard = integrate(customer,customerinfocardgroup);
            result += customerInfoCardService.addCustomerInfoCard(customerInfoCard)?1:0;
        }
        return Response.getResponseMap(0,"添加成功了"+result+"份资料卡",null);
    }
    private CustomerInfoCard integrate(Customer customer,Customerinfocardgroup customerInfoCardGroup) {
        CustomerInfoCard customerInfoCard = new CustomerInfoCard();
        customerInfoCard.setGroupid(customerInfoCardGroup.getId());
        customerInfoCard.setCid(customer.getCustomerCode());
        customerInfoCard.setCname(customer.getCustomerName());
        customerInfoCard.setMarket(customer.getAreaCode());
        customerInfoCard.setSubmarket(customer.getAreaDistrict());
        customerInfoCard.setDistrictText(customer.getDistrict());
        customerInfoCard.setAreaDistrict2Text(customer.getAreaDistrict2());
        customerInfoCard.setAreaDistrict3Text(customer.getAreaDistrict3());
        customerInfoCard.setxJuridicPerson(customer.getJuridicPerson());
        customerInfoCard.setxOfficeTel(customer.getOfficeTel());
        customerInfoCard.setxHandset(customer.getHandset());
        customerInfoCard.setxPostAddress(customer.getPostAddress());
        customerInfoCard.setxOfficeTel1(customer.getOfficeTel1());
        customerInfoCard.setxHandset2(customer.getHandset2());
        customerInfoCard.setxDeliveryAdress(customer.getDeliveryAdress());
        customerInfoCard.setTxAgentName(customer.getCustomerAgent());
        customerInfoCard.setWlAgentName(customer.getCustomerAgent1());

        customerInfoCard.setIsGeneraltaxpayer(customer.getGeneraltaxpayerStatus());
        return customerInfoCard;
    }
}
