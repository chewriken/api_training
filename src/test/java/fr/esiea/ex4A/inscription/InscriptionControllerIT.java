package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class InscriptionControllerIT {

    public final MockMvc mockMvc;

    @MockBean
    private Matches matches;

    InscriptionControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void match_user_test() throws Exception {

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

        when(matches.getMatches(userMap,agifyMap,joakimUser.name)).thenReturn(listMatch);
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=joakim&user_country=FR"))
            .andExpect(status().isOk());
        verify(matches).getMatches(userMap,agifyMap,joakimUser.name);
    }
}
