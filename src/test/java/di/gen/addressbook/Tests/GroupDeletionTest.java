package di.gen.addressbook.Tests;

import di.gen.addressbook.TestBase;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.getNavigationHelper().goToGroups();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelected();
    app.getNavigationHelper().goToGroups();

  }

}

