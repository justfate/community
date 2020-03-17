package com.example.community.provider;

import com.alibaba.fastjson.JSON;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Project: community
 * @ClassName: GithubProvider
 * @Company: JIT Northeast R & D
 * @Description: Github提供者，工具类
 * @author: zheng_wang
 * @date: 2020年03月13日
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        String url = "https://github.com/login/oauth/access_token";
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO) );
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String resp = response.body().string();
            String token = resp.split("&")[0].split("=")[1];
            return token;
        }catch(IOException e){
           e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            String resp = response.body().string();
            GithubUser githubUser = JSON.parseObject(resp, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
