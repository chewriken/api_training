package fr.esiea.ex4A.inscription;


import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class InscriptionController {

    public final HashMap <String,UserInfo> userMap = new HashMap<>();
    public final HashMap <String,AgifyInfo> agifyMap = new HashMap<>();
    public final AgifyClient agifyClient;

    public InscriptionController(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserInfo userInfo) throws InterruptedException, IOException {
        Call<AgifyInfo> call = agifyClient.defineAge(userInfo.name, userInfo.pays);
        call.enqueue(new Callback<AgifyInfo>() {
            @Override
            public void onResponse(Call<AgifyInfo> call, Response<AgifyInfo> response) {
                agifyMap.put(response.body().name,response.body());
            }

            @Override
            public void onFailure(Call<AgifyInfo> call, Throwable t) {

            }
        });
        userMap.put(userInfo.name,userInfo);
        System.out.println(userMap);
    }

    @GetMapping("/api/matches")
    public List<UserInfo> matchesUser(@RequestParam(value="userName") String name){
        //final List<UserInfo> listUser = matches.getMatches(userMap, agifyMap,name);
        final List<UserInfo> listUser = new ArrayList<>();
        for(UserInfo i : userMap.values()){
            listUser.add(i);
        }
        return listUser;
    }
}
