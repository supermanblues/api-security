package com.wonders.xlab.apisecurity.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Created by wangqiang on 16/5/5.
 */
@Entity
@Table(name = 'api_security_user')
class User extends AbstractBaseEntity {

    @Column(nullable = false, unique = true)
    String mobile

    @Column(nullable = false)
    String password

}
