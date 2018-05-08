package com.haiker.services.edas;

import org.junit.Test;

import com.aliyun.edas.open.api.EdasApiAction.App;
import com.aliyun.edas.open.api.EdasApiClient;
import com.msparis.platform.edas.poc.EdasConstant;

/**
 * @author eonezhang 28/04/2018
 */
public class EdasOldAppApiTest {

    private static final String AK = EdasConstant.AK;
    private static final String SK = EdasConstant.SK;

    @Test
    public void testAppList() {
        EdasApiClient edasApiClient =
                new EdasApiClient("http://edas.console.aliyun.com/api", AK, SK);

        try {
            String resp = edasApiClient.callApi(App.app_list.path(), null);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
