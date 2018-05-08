package com.haiker.spring.cloud.feign;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author eonezhang 04/05/2018
 */
@FeignClient(name = "EmployeeSearch")
public interface EmployeeServiceProxy {
    @RequestMapping("/employee/find/{id}")
    EmployeeInfo findById(@PathVariable(value = "id") Long id);

    @RequestMapping("/employee/findall")
    Collection<EmployeeInfo> findAll();
}

class EmployeeInfo {

}
