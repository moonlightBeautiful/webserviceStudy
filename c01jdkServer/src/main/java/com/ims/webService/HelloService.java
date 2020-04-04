package com.ims.webService;

import javax.jws.WebService;

@WebService
public interface HelloService {

    String say(String str);
}
