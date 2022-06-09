package com.crm.utilities;

import com.crm.base.TestBase;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT = 10;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }
}
