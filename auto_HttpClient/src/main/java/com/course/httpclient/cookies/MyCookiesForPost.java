package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
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

        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie-->name="+name+" value="+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    private void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.Cookies.uri");
        String  testUrl = this.url+uri;//joint

        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost();

        JSONObject param = new JSONObject();
        param.put("name","wangenhui");
        param.put("age","22");

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        String result;
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        JSONObject resultJson = new JSONObject(result);
        String success = (String) resultJson.get("wangenhui");
        String status = (String) resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);



    }

}
