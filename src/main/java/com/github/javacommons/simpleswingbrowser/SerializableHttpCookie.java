package com.github.javacommons.simpleswingbrowser;

import java.io.Serializable;
import java.net.HttpCookie;

// HttpCookie をシリアライズするための Bean
public class SerializableHttpCookie implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String value;
    
    private String comment;
    private String commentURL;
    private boolean toDiscard;
    private String domain;
    private long maxAge;
    private String path;
    private String portlist;
    private boolean secure;
    private boolean httpOnly;
    private int version;

    // Bean はデフォルトコンストラクタが必須
    public SerializableHttpCookie() {}

    public SerializableHttpCookie(HttpCookie cookie) {
        // HttpCookie のプロパティをコピー
        name = cookie.getName();
        value = cookie.getValue();
        comment = cookie.getComment();
        commentURL = cookie.getCommentURL();
        toDiscard = cookie.getDiscard();
        domain = cookie.getDomain();
        maxAge = cookie.getMaxAge();
        path = cookie.getPath();
        portlist = cookie.getPortlist();
        secure = cookie.getSecure();
        httpOnly = cookie.isHttpOnly();
        version = cookie.getVersion();
    }

    // HttpCookie への変換
    // ただし、クッキーの生成時刻が、
    // オリジナルとは異なってしまう
    public HttpCookie toHttpCookie() {
        HttpCookie cookie = new HttpCookie(name, value);

        cookie.setComment(comment);
        cookie.setCommentURL(commentURL);
        cookie.setDiscard(toDiscard);
        cookie.setDomain(domain);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        cookie.setPortlist(portlist);
        cookie.setSecure(secure);
        cookie.setHttpOnly(httpOnly);
        cookie.setVersion(version);

        return cookie;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentURL() {
        return commentURL;
    }

    public void setCommentURL(String commentURL) {
        this.commentURL = commentURL;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(long maxAge) {
        this.maxAge = maxAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPortlist() {
        return portlist;
    }

    public void setPortlist(String portlist) {
        this.portlist = portlist;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public boolean isToDiscard() {
        return toDiscard;
    }

    public void setToDiscard(boolean toDiscard) {
        this.toDiscard = toDiscard;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public boolean getHttpOnly()
    {
        return httpOnly;
    }

    public void setHttpOnly(boolean httpOnly)
    {
        this.httpOnly = httpOnly;
    }

}
