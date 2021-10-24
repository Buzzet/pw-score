package de.jannikreinefeld.cloudservice.controller;

import de.jannikreinefeld.cloudservice.passwordInspector.PasswordInspector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("api")
public class PasswordController {

    @GetMapping("/pw-strength")
    public String getPwStrength(@RequestParam() String pw){
        String seconds = PasswordInspector.getPasswordScore(pw) == 0 ? "unter 0 sec": PasswordInspector.getPasswordScore(pw) + " Sekunden";
        String minutes = PasswordInspector.getPasswordScore(pw) > 60 ? " oder auch " + PasswordInspector.getPasswordScore(pw) / 60 + " Minuten" : "";
        String hours = PasswordInspector.getPasswordScore(pw) > 3600 ? " oder auch " + PasswordInspector.getPasswordScore(pw) / 3600 + " Stunden" : "";
        return "Dauer für Brute Force: " + seconds + minutes + hours;
    }
}
