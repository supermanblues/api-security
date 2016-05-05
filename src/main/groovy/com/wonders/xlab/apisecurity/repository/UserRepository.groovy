package com.wonders.xlab.apisecurity.repository

import com.wonders.xlab.apisecurity.entity.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by wangqiang on 16/5/5.
 */
interface UserRepository extends JpaRepository<User, Long> {

    def findByMobile(mobile)

}