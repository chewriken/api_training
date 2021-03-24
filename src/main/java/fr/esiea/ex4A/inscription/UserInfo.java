package fr.esiea.ex4A.inscription;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {

    public final String email;
    public final String name;
    public final String twitter;
    public final String pays;
    public final String sexe;
    public final String sexPref;

    public UserInfo(@JsonProperty("userEmail") String email, @JsonProperty("userName") String prenom, @JsonProperty("userTweeter") String twitter,
                    @JsonProperty("userCountry") String pays, @JsonProperty("userSex") String sexe, @JsonProperty("userSexPref") String userSexPref) {
        this.email = email;
        this.name = prenom;
        this.twitter = twitter;
        this.pays = pays;
        this.sexe = sexe;
        this.sexPref = userSexPref;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", twitter='" + twitter + '\'' +
            ", pays='" + pays + '\'' +
            ", sexe='" + sexe + '\'' +
            ", sexPref='" + sexPref + '\'' +
            '}';
    }
}
