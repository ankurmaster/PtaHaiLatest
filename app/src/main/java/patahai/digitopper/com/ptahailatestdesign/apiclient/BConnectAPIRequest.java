package patahai.digitopper.com.ptahailatestdesign.apiclient;

/*
  All api method with params and url
 */


import patahai.digitopper.com.ptahailatestdesign.models.Facts;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BConnectAPIRequest {

    @GET("/app/facts.php")
    Call<Facts> factList();
}