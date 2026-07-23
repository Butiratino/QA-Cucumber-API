package ru.fakestore.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.util.UUID;

public class Hooks {
    
    @Before
    public void beforeTest(Scenario scenario){
        System.out.println("Запуск сценария: " + scenario.getName());
        System.out.println("Тег сценария: " + scenario.getSourceTagNames());
    }

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("В сценарии произошла ошибка: " + scenario.getName());
        }else{
            System.out.println("Сценарий отработал успешно: " + scenario.getName());
        }
    }
}
