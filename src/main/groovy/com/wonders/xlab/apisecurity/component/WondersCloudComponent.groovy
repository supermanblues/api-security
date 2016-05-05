package com.wonders.xlab.apisecurity.component

import com.fasterxml.jackson.databind.JsonNode
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Lazy
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

/**
 * Created by wangqiang on 16/5/5.
 */
@Lazy
@Component
class WondersCloudComponent {

    private static final logger = LoggerFactory.getLogger(WondersCloudComponent)

    @Value('${wonders_cloud_gateway}')
    String wondersCloudGateway

    @Value('${octopus_channelid}')
    String octopusChannelid

    @Value('${octopus_appkey}')
    String octopusAppkey

    @Value('${octopus_sid}')
    String octopusSid

    @Value('${octopus_token}')
    String octopusToken

    @Autowired
    RestTemplate restTemplate

    def registerUser(String mobile, String password) {

        HttpHeaders headers = new HttpHeaders()
        headers.add('octopus_channelid', octopusChannelid)
        headers.add('octopus_appkey', octopusAppkey)
        headers.add('octopus_sid', octopusSid)
        headers.add('octopus_apiid', '83026f57-0298-43f7-95ed-fbbc11637d72')

        JsonNode result = restTemplate.exchange(
                "$wondersCloudGateway?mobile=$mobile&password=$password&token=$octopusToken",
                HttpMethod.GET,
                new HttpEntity(headers),
                JsonNode
        ).getBody()

        println "result = $result"

    }

}
