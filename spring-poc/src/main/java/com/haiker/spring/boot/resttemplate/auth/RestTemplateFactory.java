package com.haiker.spring.boot.resttemplate.auth;

import java.net.URI;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 * @author eonezhang 04/05/2018
 */
public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {
    private RestTemplate restTemplate;

    @Override
    public RestTemplate getObject() throws Exception {
        return restTemplate;
    }

    @Override
    public Class<?> getObjectType() {
        return RestTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        HttpHost host = new HttpHost("localhost", 8082, "http");
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactoryBasicAuth(host);
        restTemplate = new RestTemplate(requestFactory);
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("user1", "user1Pass"));
    }

    /**
     * 使用案例，这里就不用再为每个请求指定认证逻辑，框架会自行处理
     */
    public void demo() {
        restTemplate.exchange(
                "http://localhost:8080/spring-security-rest-template/api/foos/1",
                HttpMethod.GET,
                null,
                Foo.class
        );
    }

    /**
     * 手动方式
     */
    public void oldway() {
        URI uri = null;
        String username = "e";
        String aaa = "e";
        restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<Object>(createHeaders(username, aaa)),
                              String.class);
    }

    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}

class Foo {

}
