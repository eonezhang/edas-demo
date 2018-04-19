package com.haiker.edas.demo.user.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haiker.edas.demo.order.async.AsyncEchoService;
import com.taobao.hsf.tbremoting.invoke.CallbackInvocationContext;
import com.taobao.hsf.tbremoting.invoke.HSFFuture;
import com.taobao.hsf.tbremoting.invoke.HSFResponseFuture;

/**
 * @author eonezhang 19/04/2018
 */
@RestController
public class TestAsyncController {
    @Autowired
    private AsyncEchoService asyncEchoService;

    @RequestMapping(value = "/hsf-future/{str}", method = RequestMethod.GET)
    public String testFuture(@PathVariable String str) {
        String str1 = asyncEchoService.future(str);
        String str2 = null;

        try {
            HSFFuture hsfFuture = HSFResponseFuture.getFuture();
            str = (String) hsfFuture.getResponse(3000);
        } catch (Throwable e) {
            e.printStackTrace();
            str2 = "future-exception";
        }

        return str1 + " " + str2;
    }

    @RequestMapping(value = "/hsf-future-list/{str}", method = RequestMethod.GET)
    public String testFutureList(@PathVariable String str) {
        try {

            int num = Integer.parseInt(str);

            List<String> params = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                params.add(i + "");
            }

            List<HSFFuture> hsfFutures = new ArrayList<>();

            for (String param : params) {
                asyncEchoService.future(param);
                hsfFutures.add(HSFResponseFuture.getFuture());
            }


            ArrayList<String> results = new ArrayList<>();

            for (HSFFuture hsfFuture : hsfFutures) {
                results.add((String) hsfFuture.getResponse(3000));
            }

            return Arrays.toString(results.toArray());

        } catch (Throwable t) {
            return "exception";
        }
    }

    @RequestMapping(value = "/hsf-callback/{str}", method = RequestMethod.GET)
    public String testCallback(@PathVariable String str) {

        String timestamp = System.currentTimeMillis() + "";

        CallbackInvocationContext.setContext(timestamp);
        String str1 = asyncEchoService.callback(str);
        CallbackInvocationContext.setContext(null);

        return str1 + "  " + timestamp;
    }
}
