package project.by.stormnet.functional.tests.LoginTest;

import org.testng.annotations.Factory;

public class FactoryForNegativeTestsWithSignUp {

    @Factory
    public Object[] provideEmails() {
        return new Object[]{
                new NegativeTestsWithSignUp("fffff"),
                new NegativeTestsWithSignUp("ddd@kz.ru"),
                new NegativeTestsWithSignUp("sdvsdkjnf@")
        };
    }
}