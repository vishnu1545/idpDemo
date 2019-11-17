package com.vishnu.idpDemo.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class Idp {

	@RequestMapping("/get/auth")
	public String getAuthCode() {
		return "6sfef1";
	}
	@RequestMapping("/get/jwt")
	public String getJwt() {
		
		 Claims claims = Jwts.claims().setSubject("Vishnu");
		    claims.put("auth", "ADMIN_ACCESS");
		    claims.put("resource", "values");
		    claims.put("lifeId", "123456");
		    Date now = new Date();
		    Date validity = new Date(now.getTime() + (10*60*60));

		    return Jwts.builder()//
		        .setClaims(claims)//
		        .setIssuedAt(now)//
		        .setExpiration(validity)//
		        .signWith(SignatureAlgorithm.HS256,"Vishnu1545")//
		        .compact();
	}
}
