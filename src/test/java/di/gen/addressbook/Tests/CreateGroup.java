package di.gen.addressbook.Tests;

import di.gen.addressbook.Model.GroupAtrs;
import di.gen.addressbook.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CreateGroup extends TestBase {

  @Test
  public void groupCreation()  {
    app.getNavigationHelper().goToGroups();
    List<GroupAtrs> before = app.getGroupHelper().getGroupList();
    System.out.println(before.size());
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().createGroup(new GroupAtrs("java1",null, null));
    app.getNavigationHelper().goToGroups();
    List<GroupAtrs> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(),after.size()-1);
    after.remove(after.size()-1);
    Assert.assertEquals(before, after);
  }

}
