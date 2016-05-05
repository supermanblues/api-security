package com.wonders.xlab.apisecurity.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle
import org.springframework.data.jpa.domain.AbstractPersistable

/**
 * Created by wangqiang on 16/5/5.
 */
@JsonIgnoreProperties('new')
class AbstractBaseEntity extends AbstractPersistable<Long> {

    @Override
    String toString() {
        ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE)
    }

}
