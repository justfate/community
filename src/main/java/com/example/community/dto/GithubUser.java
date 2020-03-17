package com.example.community.dto;

/**
 * @Project: community
 * @ClassName: GithubUser
 * @Company: JIT Northeast R & D
 * @Description:
 * @author: zheng_wang
 * @date: 2020年03月13日
 */
public class GithubUser {
    private String name;
    private Long id;
    private String dio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDio() {
        return dio;
    }

    public void setDio(String dio) {
        this.dio = dio;
    }
}
