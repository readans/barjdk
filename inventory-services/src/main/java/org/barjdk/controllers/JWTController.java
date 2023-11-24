package org.barjdk.controllers;

import org.barjdk.utils.cipher.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jwt")
public class JWTController {

    @Autowired
    Jwt jwt;

    @PostMapping(path = "/encriptar")
    public String encriptar(@RequestBody String reqBody) throws Exception {
        return jwt.encrypt(reqBody);
    }

    @PostMapping(path = "/desencriptar", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String desencriptar(@RequestBody String reqBody) throws Exception {
        return jwt.decrypt(reqBody);
    }
}
