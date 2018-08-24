package patahai.digitopper.com.ptahailatestdesign.apiclient;

/*
   Api call back class which is check for T class type and parse to POJO from api response
 */

import android.app.Activity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BConnectAPICallback<T> implements Callback<T> {
    private final String TAG = BConnectAPICallback.class.getSimpleName();

    public BConnectAPICallback(Activity activity) {}

    public BConnectAPICallback() {}

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        String url = call.request().url().encodedPath();
        Log.i(TAG, "Successfully Response "+url);
        int code = response.raw().code();
        T responseBody = response.body();
        if(url.endsWith("validate")){
            if(code==204) {
                if (responseBody != null)
                    onSuccess(responseBody);
                else
                    onSuccess((T)(code+""));
            }else{
                String errorMessage = errorString(response);
                if(errorMessage==null || errorMessage.equals("null"))
                    errorMessage = "Not able to validate your subscription.";
                onError(errorMessage);
            }
        }
        else if(url.endsWith("add")){
            if(code==204) {
                //subscription added
                if (responseBody != null)
                    onSuccess(responseBody);
                else
                    onSuccess((T)(code+""));
            } else {
                String errorMessage = errorString(response);
                if(errorMessage==null || errorMessage.equals("null"))
                    errorMessage = "Not able to link subscription to your account.";
                onError(errorMessage);
            }
        }else if(url.endsWith("get")){
            if(code==200 && responseBody!=null) {
                    onSuccess(responseBody);
            }
            else{
                String errorMessage = errorString(response);
                if(errorMessage==null || errorMessage.equals("null"))
                    errorMessage = "Invalid Response";
                onError(errorMessage);
            }
        }else {
            if(code==200 && responseBody!=null) {
                onSuccess(responseBody);
            }
            else{
                String errorMessage = errorString(response);
                if(errorMessage==null || errorMessage.equals("null"))
                    errorMessage = "Invalid Response";
                onError(errorMessage);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        String error;
        if (t != null && t.getMessage() != null) {
            error = t.getMessage();
        } else {
            error = "Unknown error. Please try again";
        }
        onError(error);
    }

    public abstract void onSuccess(T t);

    public abstract void onError(String error);

    private String errorString(Response<T> response){
        String errorMessage = null;
        if (null != response && null != response.errorBody()) {
            try {
                JSONObject objError = new JSONObject(response.errorBody().string());
                errorMessage = objError.getString("message");
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        }
        return errorMessage;
    }

}
