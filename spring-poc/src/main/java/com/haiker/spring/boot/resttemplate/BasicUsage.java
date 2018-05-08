package com.haiker.spring.boot.resttemplate;

import java.io.Serializable;
import java.net.URI;
import java.util.Arrays;
import java.util.Set;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author eonezhang 04/05/2018
 */
public class BasicUsage {
    private RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
    ;
    private String fooResourceUrl = null;

    public void get() {
        Foo foo = restTemplate
                .getForObject(fooResourceUrl + "/1", Foo.class);
    }

    public void header() {
        HttpHeaders httpHeaders = restTemplate
                .headForHeaders(fooResourceUrl);
        httpHeaders.getContentType();
    }

    public void post() {
        ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        Foo foo = restTemplate.postForObject(fooResourceUrl, request, Foo.class);
        ;
    }

    public void postForLocation() {
        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        URI location = restTemplate
                .postForLocation(fooResourceUrl, request);
    }

    public void exchange() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        ResponseEntity<Foo> response = restTemplate
                .exchange(fooResourceUrl, HttpMethod.POST, request, Foo.class);
        response.getStatusCode();

        Foo foo = response.getBody();
    }

    public void options() {
        Set<HttpMethod> optionsForAllow = restTemplate.optionsForAllow(fooResourceUrl);
        HttpMethod[] supportedMethods
                = { HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE };
        optionsForAllow.containsAll(Arrays.asList(supportedMethods));
    }

    public void put() {
        Foo updatedInstance = new Foo("newName");
        updatedInstance.setId(1);
        String resourceUrl = fooResourceUrl + '/' + 1;
        HttpHeaders headers = null;
        HttpEntity<Foo> requestUpdate = new HttpEntity<>(updatedInstance, headers);
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
    }

    public void putCallback() {
        Foo updatedInstance = new Foo("newName");
        updatedInstance.setId(1);
        String resourceUrl = fooResourceUrl + '/' + 1;
        restTemplate.execute(
                resourceUrl,
                HttpMethod.PUT,
                requestCallback(updatedInstance),
                clientHttpResponse -> null);
    }

    public void delete() {
        String entityUrl = fooResourceUrl + "/" + 1;
        restTemplate.delete(entityUrl);
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory2() {
        int timeout = 5000;
        RequestConfig config = RequestConfig.custom()
                                            .setConnectTimeout(timeout)
                                            .setConnectionRequestTimeout(timeout)
                                            .setSocketTimeout(timeout)
                                            .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }

    RequestCallback requestCallback(final Foo updatedInstance) {
        return clientHttpRequest -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(clientHttpRequest.getBody(), updatedInstance);
            clientHttpRequest.getHeaders().add(
                    HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            clientHttpRequest.getHeaders().add(
                    HttpHeaders.AUTHORIZATION, "Basic " + "123123");
        };
    }

}

@Data
@NoArgsConstructor
class Foo implements Serializable {
    private long id;

    private String name;
    // standard getters and setters

    public Foo(String name) {
        this.name = name;
    }
}
