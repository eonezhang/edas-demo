package com.haiker.spring.cloud.feign;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eonezhang 04/05/2018
 */
@RefreshScope
@RestController
public class FeignEmployeeInfoController {
    @Autowired
    EmployeeServiceProxy proxyService;

    @RequestMapping("/dashboard/feign/{myself}")
    public EmployeeInfo findme(@PathVariable Long myself) {
        return proxyService.findById(myself);

    }

    @RequestMapping("/dashboard/feign/peers")
    public Collection<EmployeeInfo> findPeers() {
        return proxyService.findAll();
    }
}
