package fr.esiea.ex4A.inscription;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class InscriptionController {

    public final List <UserInfo> listUser = new ArrayList<>();

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserInfo userInfo) throws InterruptedException{
        System.out.println(userInfo);
        listUser.add(userInfo);
    }

    @GetMapping("/api/matches")
    public List<UserInfo> matches(@RequestParam(value="name") String name,
                                  @RequestParam(value="twitter") String twitter){
        return listUser;
    }
}
