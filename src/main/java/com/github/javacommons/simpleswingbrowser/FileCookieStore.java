package com.github.javacommons.simpleswingbrowser;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import sun.net.www.protocol.http.InMemoryCookieStore;

public class FileCookieStore implements MyCookieStore {
    // 委譲を行なう CookieStore
    private MyCookieStore store;

    // Cookieをシリアライズ/デシリアライズするファイル
    private File file;
    
    public FileCookieStore() {
        this.store = new MyInMemoryCookieStore();

        // システムプロパティからホームディレクトリを取得し
        // .cookies ファイルを配置する
        String home = System.getProperty("user.home");
        file = new File(home + File.separator + ".cookies");
    }

    @SuppressWarnings("unchecked")
    public void load() {
        /*
        HashMap<URI, List<SerializableHttpCookie>> map = null;

        // XML ファイルからデシリアライズ
        try {
            XMLDecoder decoder
                = new XMLDecoder(new BufferedInputStream(
                                     new FileInputStream(file)));
            Object obj = decoder.readObject();
            map = (HashMap<URI, List<SerializableHttpCookie>>)obj;
            decoder.close();
        } catch (FileNotFoundException ex) {
            return;
        }

        if (map == null) {
            return;
        }

        // HttpCookie に再変換し、InMemoryCookieStore に追加
        for (URI uri: map.keySet()) {
            List<SerializableHttpCookie> cookies = map.get(uri);
            for (SerializableHttpCookie cookie: cookies) {
                store.add(uri, cookie.toHttpCookie());
            }
        }*/
    }

    public void save() throws IOException {
        /*
        HashMap<URI, List<SerializableHttpCookie>> map
            = new HashMap<URI, List<SerializableHttpCookie>>();
        
        // URI ごとに InMemoryCookieStore からクッキーを取り出し、
        // シリアライズが可能なように変換
        List<URI> uris = store.getURIs();
        for (URI uri: uris) {
            List<HttpCookie> cookies = store.get(uri);
            List<SerializableHttpCookie> tmpCookies 
                = new ArrayList<SerializableHttpCookie>();
            for(HttpCookie cookie: cookies) {
                if (cookie.getMaxAge() != -1) {
                    tmpCookies.add(new SerializableHttpCookie(cookie));
                }
            }
            if (tmpCookies.size() != 0) {
                map.put(uri, tmpCookies);
            }
        }

        if (map.size() != 0) {
            // XML ファイルにシリアライズ
            XMLEncoder encoder 
                = new XMLEncoder(new BufferedOutputStream(
                                     new FileOutputStream(file)));
            encoder.writeObject(map);
            encoder.close();
        }*/
    }
    
    public void add(URI uri, MyHttpCookie cookie) {
        store.add(uri, cookie);
    }

    public List<MyHttpCookie> get(URI uri) {
        return store.get(uri);
    }

    public List<MyHttpCookie> getCookies() {
        return store.getCookies();
    }
    
    public List<URI> getURIs() {
        return store.getURIs();
    }
    
    public boolean remove(URI uri, MyHttpCookie ck) {
        return store.remove(uri, ck);
    }

    public boolean removeAll() {
        return store.removeAll();
    }
}
