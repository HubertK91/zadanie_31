package pl.hk.zadanie_31.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes
            , ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        System.out.println("URI request: " + httpRequest.getURI());
        return clientHttpRequestExecution.execute(httpRequest,bytes);
    }
}
