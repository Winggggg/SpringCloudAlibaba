package com.wing.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heweiye
 * @version 1.0
 * @description jwt信息包装
 * @date 2020/1/15 17:40
 */
@Setter
@Getter
public class Jwt {

//    {
//        "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ3aW5nIiwic2NvcGUiOlsiYWxsIl0sImV4cCI6MTU3OTA4Mjc1MCwiYXV0aG9yaXRpZXMiOlsiYWRtaW4iXSwianRpIjoiMjU1OWFmNTAtZTQ3YS00NmJmLTkxZWQtNzQ0MmE1ZjRmMGE3IiwiY2xpZW50X2lkIjoiYWRtaW4iLCJlbmhhbmNlIjoiZW5oYW5jZSBpbmZvIn0.MfxbZl7m9NWNIcWPIC-CUIu-brROjj1h1QIcD4N5Z-4",
//            "token_type": "bearer",
//            "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ3aW5nIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjI1NTlhZjUwLWU0N2EtNDZiZi05MWVkLTc0NDJhNWY0ZjBhNyIsImV4cCI6MTU3OTk0MzE1MCwiYXV0aG9yaXRpZXMiOlsiYWRtaW4iXSwianRpIjoiNzg2OTM3ZjctYzZlNC00YmI5LTlmZTAtYTE0Nzc1NDJkZGEyIiwiY2xpZW50X2lkIjoiYWRtaW4iLCJlbmhhbmNlIjoiZW5oYW5jZSBpbmZvIn0.yclm570PDMpsAX3_EjnfcrL7A1ch9NddmolkBZHZwjQ",
//            "expires_in": 3599,
//            "scope": "all",
//            "enhance": "enhance info",
//            "jti": "2559af50-e47a-46bf-91ed-7442a5f4f0a7"
//    }

    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String jti;
    private String enhance;
}
