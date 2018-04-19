package com.haiker.edas.demo.user.async;

import com.alibaba.boot.hsf.annotation.AsyncOn;
import com.haiker.edas.demo.order.async.AsyncEchoService;
import com.taobao.hsf.exception.HSFException;
import com.taobao.hsf.tbremoting.invoke.CallbackInvocationContext;
import com.taobao.hsf.tbremoting.invoke.HSFResponseCallback;

/**
 * @author eonezhang 19/04/2018
 */
@AsyncOn(interfaceName = AsyncEchoService.class, methodName = "callback")
public class AsyncEchoResponseListener implements HSFResponseCallback {
    @Override
    public void onAppException(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onAppResponse(Object appResponse) {
        Object timestamp = CallbackInvocationContext.getContext();
        System.out.println(timestamp + "   " + appResponse);
    }

    @Override
    public void onHSFException(HSFException hsfEx) {
        hsfEx.printStackTrace();
    }
}
