package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MatchesTest {

    public final Matches matches = new Matches();
    @Test
    void matches_test() throws Exception {
        HashMap<String,UserInfo> userMap = new HashMap<>();
        UserInfo ElyUser = new UserInfo("Ely@Ely","Ely","Ely","FR","M","F");
        UserInfo GanaelUser = new UserInfo("Ganael@Ganael","Ganael","Ganael","FR","F","M");
        userMap.put(ElyUser.name,ElyUser);
        userMap.put(GanaelUser.name,GanaelUser);

        HashMap<String,AgifyInfo> agifyMap = new HashMap<>();
        AgifyInfo ElyInfo = new AgifyInfo("Ely",22,303,"FR");
        AgifyInfo GanaelInfo = new AgifyInfo("Ganael",23,27695,"FR");
        agifyMap.put(ElyInfo.name,ElyInfo);
        agifyMap.put(GanaelInfo.name,GanaelInfo);
        System.out.println(agifyMap);

        List<UserInfo> listMatch = matches.getMatches(userMap,agifyMap,ElyUser.name);
        System.out.println(listMatch);
        assertThat(listMatch).contains(GanaelUser);
    }
}
