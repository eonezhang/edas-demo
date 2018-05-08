package com.haiker.services.edas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.aliyun.edas.open.api.EdasApiAction.App;
import com.aliyun.edas.open.api.EdasApiClient;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.edas.model.v20170801.DeployApplicationRequest;
import com.aliyuncs.edas.model.v20170801.DeployApplicationResponse;
import com.aliyuncs.edas.model.v20170801.ListDeployGroupRequest;
import com.aliyuncs.edas.model.v20170801.ListDeployGroupResponse;
import com.aliyuncs.edas.model.v20170801.ListDeployGroupResponse.DeployGroup;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.msparis.platform.edas.poc.EdasConstant;

/**
 * @author eonezhang 23/04/2018
 */
public class EdasTest {

    @Test
    @Ignore
    public void initEdas() throws ClientException {
        String region = "cn-hangzhou";
        String accessKeyId = EdasConstant.AK;
        String accessKeySecret = EdasConstant.SK;
        String productName = "EDAS";
        String domain = "edas.cn-hangzhou.aliyuncs.com";

        DefaultProfile.addEndpoint(region, region, productName, domain);
        DefaultProfile profile = DefaultProfile.getProfile(region, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);

        String appid = "32eec081-a42b-4ee2-9628-2fb5f7b26842";
        ListDeployGroupRequest req = new ListDeployGroupRequest();
        req.setAppId(appid);
        ListDeployGroupResponse resp = client.getAcsResponse(req);
        if (resp.getCode() == 200) {
            List<DeployGroup> deployGroups = resp.getDeployGroupList();
            if (!CollectionUtils.isEmpty(deployGroups)) {
                for (DeployGroup deployGroup : deployGroups) {
                    System.out.printf("groupName: %s, groupId: %s\n", deployGroup.getGroupName(),
                                      deployGroup.getGroupId());
                }
            }
        }
    }

    @Test
    @Ignore
    public void deployOrderService() throws ClientException {
        String region = "cn-hangzhou";
        String accessKeyId = EdasConstant.AK;
        String accessKeySecret = EdasConstant.SK;
        String productName = "EDAS";
        String domain = "edas.cn-hangzhou.aliyuncs.com";

        DefaultProfile.addEndpoint(region, region, productName, domain);
        DefaultProfile profile = DefaultProfile.getProfile(region, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);

        String appid = "32eec081-a42b-4ee2-9628-2fb5f7b26842";

        DeployApplicationRequest req = new DeployApplicationRequest();
        req.setAppId(appid);
        req.setBatch(1);
        req.setDeployType("url");
        req.setDesc("deploy from program");
        req.setGroupId("all");
        req.setWarUrl("http://10.81.180.38/order-service-0.0.1.jar");
        req.setPackageVersion(System.currentTimeMillis() + "");
        DeployApplicationResponse resp = client.getAcsResponse(req);
        System.out.printf("%s\n", resp.getMessage());

    }

    @Test
    public void edasv1Test() throws Exception {
        String host = "http://edas.console.aliyun.com/api";
        String ak = "TODO";
        String sk = "TODO";
        EdasApiClient client = new EdasApiClient(host, ak, sk);
        Map<String, String> params = new HashMap<>();
        String result = client.callApi(App.app_list.path(), params);
        System.out.printf("%s\n", result);
    }
}
