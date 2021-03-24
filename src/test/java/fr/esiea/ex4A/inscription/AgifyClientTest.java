package fr.esiea.ex4A.inscription;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AgifyClientTest {

    @ParameterizedTest
    @CsvSource({
        "Joakim,FR",
        "Janne,FR",
        "Laure,FR"
    })
    void agifyClient_testIT(String name, String country) throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        AgifyClient agifyClient = retrofit.create(AgifyClient.class);

        Response<AgifyInfo> response = agifyClient.defineAge(name, country).execute();
        AgifyInfo agifyInfo = response.body();
        assertEquals(agifyInfo.name, name);
        assertEquals(agifyInfo.country, country);
        assertThat(agifyInfo.toString()).isEqualTo("AgifyInfo{name='"+agifyInfo.name
            +"', age="+agifyInfo.age
            +", count="+agifyInfo.count
            +", country='"+agifyInfo.country+"'}");
    }

}

