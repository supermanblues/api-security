package com.wonders.xlab.apisecurity.service

import com.wonders.xlab.apisecurity.ApiSecurityApplicationTests
import com.wonders.xlab.apisecurity.entity.User
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by wangqiang on 16/5/5.
 */
class UserServiceTest extends ApiSecurityApplicationTests {

    @Autowired
    UserService userService

    @Test
    void testFindByMobile() {
        def user = userService.findByMobile('15221093750')
        println "user = $user"
    }

    @Test
    void testSave() {
        def user = new User(mobile: '15221093750', password: '123456')
        userService.save(user)
    }

}
