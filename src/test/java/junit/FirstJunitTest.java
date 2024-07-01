package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class FirstJunitTest {

    @BeforeAll

//    static void beforeAll () {
//        //Configuration.browser=
//    }
//
//    @AfterAll (){
//
//    }
//
//    @BeforeEach (){
//
//    }
//    @AfterEach (){
//
//    }


    @Test
    void firstTest () {

        Assertions.assertTrue(3>2);

    }
}
