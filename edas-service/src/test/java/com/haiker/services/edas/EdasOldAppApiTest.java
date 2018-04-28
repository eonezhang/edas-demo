package com.haiker.services.edas;

import org.junit.Test;

import com.aliyun.edas.open.api.EdasApiAction.App;
import com.aliyun.edas.open.api.EdasApiClient;

/**
 * @author eonezhang 28/04/2018
 */
public class EdasOldAppApiTest {

    private static final String AK = "***";
    private static final String SK = "****";

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
