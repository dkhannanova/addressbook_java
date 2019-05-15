package di.gen.addressbook;

import di.gen.addressbook.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  //создаем логгер привязав его к testbase чтобы было видно откуда строка лога создается
  Logger logger = LoggerFactory.getLogger(TestBase.class);
  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  //Запуск и закрытие  сеанса веб-браузера перед каждым сьютом
  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown()  {
    app.stop();
  }



//настройки логирования (в т.ч. в файл используя библиотеку Logback (ищем в search.maven.org строку для подключения, вставляем в build.gradle))
@BeforeMethod
//Method m содержит информацию о тестовом методе,который сейчас запускается, необходимо для включения класса метода в строки лога, параметр Object позволяет выводить в лог параметры с которыми тест запускается.Также в logback надо создать файл logback.xml  - туда будет записываться лог
public void logTestStart(Method m, Object[]p) {
    logger.info("start test" + m.getName(),"параметры"+ Arrays.asList(p));
}

@AfterMethod(alwaysRun = true)
public void logTestStop(Method m) {
logger.info("stop test",m.getName());
}
}

