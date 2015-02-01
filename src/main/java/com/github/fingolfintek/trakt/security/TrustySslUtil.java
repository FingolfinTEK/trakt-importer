package com.github.fingolfintek.trakt.security;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import com.squareup.okhttp.OkHttpClient;
import retrofit.client.OkClient;

public class TrustySslUtil {

    public static OkClient trustyClient() throws GeneralSecurityException {
        return trustyClient(360);
    }

    public static OkClient trustyClient(final long timeoutInSeconds) throws NoSuchAlgorithmException, KeyManagementException {
        final OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        client.setReadTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        client.setWriteTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        client.setSslSocketFactory(createTrustySslSocketFactory());
        client.setHostnameVerifier((s, sslSession) -> true);
        return new OkClient(client);
    }

    private static SSLContext createTrustySslContext() throws NoSuchAlgorithmException, KeyManagementException {
        final TrustManager[] trustAllCerts = new TrustManager[] { new TrustAllCertificatesManager() };
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        return sslContext;
    }

    private static SSLSocketFactory createTrustySslSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        return createTrustySslContext().getSocketFactory();
    }

    private static class TrustAllCertificatesManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}
