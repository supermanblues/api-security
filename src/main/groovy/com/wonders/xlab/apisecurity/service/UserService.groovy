package com.wonders.xlab.apisecurity.service

import com.wonders.xlab.apisecurity.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

/**
 * Created by wangqiang on 16/5/5.
 */
@Component
class UserService {

    @Autowired
    UserRepository userRepository

    @Cacheable(value = 'userCache', key = "'apisecurity:user:mobile:' + #p0")
    def findByMobile(mobile) { userRepository.findByMobile(mobile) }

    @CachePut(value = 'userCache', key = "'apisecurity:user:mobile:' + #user.mobile")
    def save(user) { userRepository.save(user) }

}
