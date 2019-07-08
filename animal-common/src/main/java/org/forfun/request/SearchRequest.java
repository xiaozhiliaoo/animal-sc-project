package org.forfun.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SearchRequest {

    /**
     * 分页查询页
     */
    @JsonProperty(defaultValue = "0")
    private Integer page = 0;
    /**
     * 分页页面大小
     */
    @JsonProperty(defaultValue = "20")
    private Integer size = 10;
    /**
     * 查询开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date from;
    /**
     * 分页结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date to;
    /**
     * 名称查询
     */
    @JsonProperty
    private String name;
    /**
     * 按昵称查询
     */
    @JsonProperty
    private String nickname;
    /**
     * 按手机号查询
     */
    @JsonProperty
    private String mobile;
    /**
     * 推荐人
     */
    @JsonProperty
    private String referrer;
    /**
     * 渠道二维码名称
     */
    @JsonProperty
    private String channelCodeName;
    /**
     * 复合查询字段
     */
    @JsonProperty
    private String condition;
    /**
     * 通过ID进行查询
     */
    @JsonProperty
    private String id;
    /**
     * 通过类型查询
     */
    @JsonProperty
    private String type;
    /**
     * 会员关系级别查询
     */
    @JsonProperty
    private Integer level;
}
