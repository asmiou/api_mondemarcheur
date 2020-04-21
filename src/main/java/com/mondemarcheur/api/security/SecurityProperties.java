package com.mondemarcheur.api.security;

public class SecurityProperties {
    protected static final String SECRET = "L3MNa9w9PHHJF1Jjv67Jqb5P8DjDdmOr";
    protected static final long EXPIRATION_TIME = 864_000_000; // 10 days
    protected static final String TOKEN_PREFIX = "Bearer ";
    protected static final String HEADER_STRING = "Authorization";
    protected static final String SIGN_UP_URL = "/sign-up";
}
