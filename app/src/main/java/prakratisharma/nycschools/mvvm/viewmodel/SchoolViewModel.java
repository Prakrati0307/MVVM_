package prakratisharma.nycschools.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import prakratisharma.nycschools.mvvm.model.SchoolDetails;
import prakratisharma.nycschools.mvvm.repository.SchoolAPIRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<SchoolDetails>> schoolList;

    //we will call this method to get the data
    public LiveData<List<SchoolDetails>> getSchoolDetail() {
        //if the list is null
        if (schoolList == null) {
            schoolList = new MutableLiveData<List<SchoolDetails>>();
            //we will load it asynchronously from server in this method
            loadSchoolDetails();
        }

        //finally we will return the list
        return schoolList;
    }

    //This method is using Retrofit to get the JSON data from URL
    private void loadSchoolDetails() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SchoolAPIRequest.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchoolAPIRequest api = retrofit.create(SchoolAPIRequest.class);
        Call<List<SchoolDetails>> call = api.getSchoolDetail();


        call.enqueue(new Callback<List<SchoolDetails>>() {
            @Override
            public void onResponse(Call<List<SchoolDetails>> call, Response<List<SchoolDetails>> response) {

                //finally we are setting the list to our MutableLiveData
                schoolList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SchoolDetails>> call, Throwable t) {

            }
        });
    }

}