package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.qiniuoss")
@Data
//七牛云
public class OssProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String domin;
}
