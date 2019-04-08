package di.gen.addressbook.Tests;

import di.gen.addressbook.Model.GroupAtrs;
import di.gen.addressbook.TestBase;
import org.testng.annotations.Test;

public class CreateGroup extends TestBase {

  @Test
  public void groupCreation()  {
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().initiateNewGroup();
    app.getGroupHelper().fillGroup(new GroupAtrs("java1",null, null));
    app.getGroupHelper().submitNewGroup();
  }

}
