package di.gen.addressbook.Tests;

import di.gen.addressbook.Model.ContactAtrs;
import di.gen.addressbook.Model.GroupAtrs;
import di.gen.addressbook.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public List<GroupAtrs> assurePreconditions(){
    app.getNavigationHelper().goToGroups();
    List<GroupAtrs> before = app.getGroupHelper().getGroupList();
    if (before.size()==0)
    {app.getGroupHelper().createGroup(new GroupAtrs("java1",null, null));
      app.getNavigationHelper().goToGroups();
    }
    return before;
  }

  @Test
  public void testDeleteGroup() throws Exception {
        //System.out.println(before);
     app.getGroupHelper().selectGroup(assurePreconditions().size()-1);
      app.getGroupHelper().deleteSelected();
      app.getNavigationHelper().goToGroups();
      List<GroupAtrs> after = app.getGroupHelper().getGroupList();
    assurePreconditions().remove(assurePreconditions().size()-1);
    Assert.assertEquals(assurePreconditions(), after);
  }

}

