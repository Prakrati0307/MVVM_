package prakratisharma.nycschools.mvvm.repository;

import java.util.List;

import prakratisharma.nycschools.mvvm.model.SchoolDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SchoolAPIRequest {
    String BASE_URL = "https://data.cityofnewyork.us/resource/";
   /*  @GET("f9bf-2cp4.json")
    Call<List<School>> getSchool();

   @GET("f9bf-2cp4.json")
    Call<List<SchoolDetails>> getSchoolDetail(@Query("school_name") String schoolName);*/

  @GET("f9bf-2cp4.json")
    Call<SchoolDetails> getSchoolDetail(@Path("school_name") String schoolName);

    @GET("f9bf-2cp4.json")
    Call<List<SchoolDetails>> getSchoolDetail();
}
