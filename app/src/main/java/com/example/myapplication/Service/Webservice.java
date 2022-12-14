package com.example.myapplication.Service;

import android.os.Bundle;

import com.example.myapplication.Utils.GsonUtils;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/**
 *
 * @ProjectName: Webservice
 * @Package: com.example.myapplication.Service
 * @Description: java类作用描述
 * @Author: ZHT
 * @CreateDate: 2022/10/29
 */

/**
 * Webservice访问类
 */
public class Webservice {
    static HostnameVerifier hv = new HostnameVerifier() {
        public boolean verify(String urlHostName, SSLSession session) {
            System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
            return true;
        }
    };

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }

    /**
     * 调用 paramJson 转成 jsonToString
	 *   Bundle params = new Bundle();
     *   params.putString("WoolinteValue", paramJson);
     */
    public static String callWebService( String URL, String methodName, Bundle params, int ms) {
        String nameSpace = "http://tempuri.org/";
        // 实例化SoapObject对象
        SoapObject request = new SoapObject(nameSpace, methodName);
        // 设置调用参数
        for (String key : params.keySet()) {
            String s = params.getString(key);
            if (s != null && s.contains("'")) {
                request.addProperty(key, s.replaceAll("'", "''"));
            } else {
                request.addProperty(key, params.get(key));
            }
        }
        // 设置SOAP请求信息(参数部分为SOAP协议版本号，与你要调用的webService中版本号一致)
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        // 是否.net的webservice
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        HttpTransportSE ht;
        String sjson = null;
        try {
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hv);//执行方法的最前面一定要加上这两个方法的调用
            // 超时设置
            if (ms < 1) {
                ht = new HttpTransportSE(URL);
            } else {
                ht = new HttpTransportSE(URL, ms);
            }
            ht.setReadTimeout(ms);
            ht.call(nameSpace + methodName, envelope);

            if (envelope.getResponse() != null) {
                sjson = envelope.getResponse().toString();
            }
            assert sjson != null;
            if (sjson.startsWith("[")) {
                sjson = "{ResData:" + sjson + "}";
            }
            sjson = sjson.replace(":null,", ":\"\",");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sjson;
    }


}
