package com.wonders.xlab.apisecurity.component

import com.wonders.xlab.apisecurity.ApiSecurityApplicationTests
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by wangqiang on 16/5/5.
 */
class WondersCloudComponentTest extends ApiSecurityApplicationTests {

    @Autowired
    WondersCloudComponent component

    @Test
    void testRegisterUser() {
        component.registerUser('15221093750', '123456')
    }

}
