package fr.esiea.ex4A.inscription;


import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class InscriptionController {

    public final HashMap <String,UserInfo> userMap = new HashMap<>();
    public final HashMap <String,AgifyInfo> agifyMap = new HashMap<>();
    public final AgifyClient agifyClient;
    public final Matches matches;

    public InscriptionController(AgifyClient agifyClient, Matches matches) {
        this.agifyClient = agifyClient;
        this.matches = matches;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserInfo userInfo) throws IOException {
        if (!agifyMap.containsKey(userInfo.name)) {
            Response<AgifyInfo> response = agifyClient.defineAge(userInfo.name, userInfo.pays).execute();
            AgifyInfo agifyInfo = response.body();
            agifyMap.put(agifyInfo.name, agifyInfo);
            userMap.put(userInfo.name, userInfo);
            System.out.println(agifyMap);
        }
    }

    @GetMapping("/api/matches")
    public List<UserInfo> matchesUser(@RequestParam(value="userName") String name){
        final List<UserInfo> listUser = matches.getMatches(userMap, agifyMap,name);
        return listUser;
    }
}
