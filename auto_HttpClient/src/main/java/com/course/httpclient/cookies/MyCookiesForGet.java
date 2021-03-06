package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    @BeforeTest
    private void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String  testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        //HttpClient client = new DefaultHttpClient();
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        CookieStore store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie-->name="+name+" value="+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    private void testGetWithCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        String  testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        client.setCookieStore(this.cookieStore);

        HttpResponse response = client.execute(get);

        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode == 200){
            System.out.println("success:"+statusCode);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }else{
            System.out.println("other:"+statusCode);
        }
    }


}
