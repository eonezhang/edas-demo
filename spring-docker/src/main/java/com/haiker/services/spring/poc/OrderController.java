package com.haiker.services.spring.poc;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

/**
 * @author eonezhang 04/05/2018
 */
public class OrderController {
    private RestTemplate restTemplate = new RestTemplate();

    public void forEntity() {
        String url = "";
        ResponseEntity<String> response = restTemplate.getForEntity(url + "/",
                                                                    String.class);
        response.getStatusCode();
        response.getBody();

    }

    public void forObject() {
        String url = null;
        Foo foo = restTemplate.getForObject(url + "/", Foo.class);
    }

    public void headers() {
        URI url = null;
        HttpHeaders headers = restTemplate.headForHeaders(url);
        headers.getContentType();
    }

    public void postForCreate() {
        URI url = null;
        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        restTemplate.postForObject(url, request, Foo.class);
    }

    public void postForLocation() {
        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        URI url = null;
        URI location = restTemplate.postForLocation(url, request);
    }

    public void options() {
        URI url = null;
        Set<HttpMethod> options = restTemplate.optionsForAllow(url);
    }

    public void exchange() {
        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        URI url = null;
        ResponseEntity<Foo> response = restTemplate.exchange(url, HttpMethod.POST, request, Foo.class);
        response.getStatusCode();
        response.getBody();
    }

    public void putExchange() {
        URI url = null;
        MultiValueMap<String, String> headers = null;
        Foo foo = new Foo("bar");
        HttpEntity<?> request = new HttpEntity<>(foo, headers);
        restTemplate.exchange(url, HttpMethod.PUT, request, Void.class);
    }

    public void exchangeCallback() {
        URI url = null;
        restTemplate.execute(url, HttpMethod.PUT, new RequestCallback() {
            @Override
            public void doWithRequest(ClientHttpRequest request) throws IOException {

            }
        }, new ResponseExtractor<Object>() {
            @Override
            public Object extractData(ClientHttpResponse response) throws IOException {
                return null;
            }
        });
    }
}

class Foo implements Serializable {
    private long id;
    private String name;

    public Foo() {
    }

    public Foo(String name) {
        this.name = name;
    }
}
