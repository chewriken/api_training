package fr.esiea.ex4A.inscription;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Matches {

    public List<UserInfo> getMatches(HashMap<String,UserInfo> userMap, HashMap<String,AgifyInfo> agifyMap,String name) {
        final AgifyInfo userAgify = agifyMap.get(name); final UserInfo userInfo = userMap.get(name); final List<UserInfo> matches = new ArrayList<>();
        for(AgifyInfo i : agifyMap.values()){
            if(i.age<= userAgify.age+4 && i.age>= userAgify.age-4){
                UserInfo potentialMatch = userMap.get(i.name);
                 if(potentialMatch.sexe.equals(userInfo.sexPref) && potentialMatch.pays.equals(userInfo.pays) && userInfo.twitter!= potentialMatch.twitter){
                    matches.add(userMap.get(i.name));
                }
            }
        } return matches;
    }

}
