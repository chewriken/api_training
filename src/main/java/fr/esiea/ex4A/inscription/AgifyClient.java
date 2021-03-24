package fr.esiea.ex4A.inscription;

import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Service
public interface AgifyClient {

    @GET(".")
    Call<AgifyInfo> defineAge(@Query("name")String name, @Query("country_id")String country);

}
