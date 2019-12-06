package com.magic.redis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("笔记页信息")
public class NotePageBo {

    @ApiModelProperty("笔记页Id")
    private Long notepageId;

    @ApiModelProperty("笔记页服务端Id")
    private Long notepageServerId;

    @ApiModelProperty("笔记Id（本地）")
    private Long notebookId;

    @ApiModelProperty("作业id")
    private Long taskId;

    @ApiModelProperty("创建时间戳，单位：毫秒")
    private Long createTime;

    @ApiModelProperty("更新时间戳，单位：毫秒")
    private Long updateTime;


    /** 以下为业务使用 */
    @ApiModelProperty("页码")
    @JsonIgnore
    private int pageNum;
    //宽度和高度,取最后一层的
    @ApiModelProperty("页宽度")
    @JsonIgnore
    private int pageWidth;
    @ApiModelProperty("页高度")
    @JsonIgnore
    private int pageHeight;

}
