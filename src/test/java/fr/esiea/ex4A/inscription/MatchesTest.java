package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MatchesTest {

    public final Matches matches = new Matches();
    @Test
    void matches_test() throws Exception {
        HashMap<String,UserInfo> userMap = new HashMap<>();
        UserInfo joakimUser = new UserInfo("joakim@joakim","joakim","joakim","FR","M","F");
        UserInfo isabelleUser = new UserInfo("isabelle@isabelle","isabelle","isabelle","FR","F","M");
        userMap.put(joakimUser.name,joakimUser);
        userMap.put(isabelleUser.name,isabelleUser);

        HashMap<String,AgifyInfo> agifyMap = new HashMap<>();
        AgifyInfo joakimInfo = new AgifyInfo("joakim",54,303,"FR");
        AgifyInfo isabelleInfo = new AgifyInfo("isabelle",51,27695,"FR");
        agifyMap.put(joakimInfo.name,joakimInfo);
        agifyMap.put(isabelleInfo.name,isabelleInfo);

        List<UserInfo> listMatch = matches.getMatches(userMap,agifyMap,joakimUser.name);
        assertThat(listMatch).contains(isabelleUser);

    }
}
