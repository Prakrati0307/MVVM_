package prakratisharma.nycschools.mvvm.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import prakratisharma.nycschools.mvvm.model.SchoolDetails;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolRepository {
    private static SchoolAPIRequest service;
    private static SchoolRepository apiManager;

    private static String GETURL = "https://data.cityofnewyork.us/resource/";


    private SchoolRepository() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GETURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SchoolAPIRequest.class);
    }

    public static SchoolRepository getInstance() {
        if (apiManager == null) {
            apiManager = new SchoolRepository();
        }
        return apiManager;
    }



   /* public void getSchoolDetail(String schoolName, Callback<List<SchoolDetails>> callback) {
        Call<List<SchoolDetails>> regionsCall = service.getSchoolDetail(schoolName);
        regionsCall.enqueue(callback);
    }
*/
    public LiveData<SchoolDetails> getSchoolDetail(String schoolName) {
        final MutableLiveData<SchoolDetails> data = new MutableLiveData<>();

        service.getSchoolDetail( schoolName).enqueue(new Callback<SchoolDetails>() {
            @Override
            public void onResponse(Call<SchoolDetails> call, Response<SchoolDetails> response) {
               simulateDelay();
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SchoolDetails> call, Throwable t) {
                data.setValue(null);
            }


        });

        return data;
    }
    private void simulateDelay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}