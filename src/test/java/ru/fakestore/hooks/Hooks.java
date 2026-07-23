package ru.fakestore.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import java.util.UUID;

public class Hooks {
    
    @After
    public void afterScenario(Scenario scenario){
        String reportId = UUID.randomUUID().toString().substring(0,8);

        String cdnLink = "cdn.fakestore-reports.com/reports/" + reportId + "/html";
        if(scenario.isFailed()){
            System.out.println("В сценарии произошла ошибка: " + scenario.getName());
        }else{
            System.out.println("Сценарий отработал успешно: " + scenario.getName());
        }
        System.out.println("Ссылька на отчёт: " + cdnLink);
    }
}
