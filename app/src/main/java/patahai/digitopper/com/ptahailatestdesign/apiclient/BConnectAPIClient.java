package patahai.digitopper.com.ptahailatestdesign.apiclient;


import android.content.Context;
import android.os.Build;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import info.guardianproject.netcipher.client.TlsOnlySocketFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
  Set base url, logger type and interceptor
 */
public class BConnectAPIClient {


    private static final String BASE_URL_PROD_ORIGIN = "http://patahai.co";

    private static BConnectAPIRequest apiRequest;

    public static void init(Class<BConnectAPIRequest> requestClass, Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = null;

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(new UserAgentInterceptor("Businessweek/" + 1 + " Android " + Build.VERSION.RELEASE))
                .addInterceptor(interceptor)
                /*.sslSocketFactory(getSSLConfig(context))*/
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_PROD_ORIGIN)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        apiRequest = retrofit.create(requestClass);
    }

    public static BConnectAPIRequest getRequest() {
        return apiRequest;
    }

    private static SSLSocketFactory getSSLConfig(Context context) throws CertificateException, IOException,
            KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        // Loading CAs from an InputStream
        CertificateFactory cf;
        cf = CertificateFactory.getInstance("X.509");

        Certificate ca = null;
        // I'm using Java7. If you used Java6 close it manually with finally.
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try (InputStream cert = context.getResources().openRawResource(R.raw.bloomberg_certificate)) {
                ca = cf.generateCertificate(cert);
            }
        } else {
            try {
                InputStream cert = context.getResources().openRawResource(R.raw.bloomberg_certificate);
                ca = cf.generateCertificate(cert);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/


        // Creating a KeyStore containing our trusted CAs
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);

        // Creating a TrustManager that trusts the CAs in our KeyStore.
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);

        // Creating an SSLSocketFactory that uses our TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLSv1");
        sslContext.init(null, tmf.getTrustManagers(), null);

        return new TlsOnlySocketFactory(sslContext.getSocketFactory());
    }
}
